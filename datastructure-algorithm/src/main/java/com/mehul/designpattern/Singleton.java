package com.mehul.designpattern;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * This is a demonstration of singleton design pattern, which will handle below
 * issues
 * <ul>
 * <li>Reflection</li>
 * <li>Clone</li>
 * <li>Serialization/De-serialization</li>
 * <li>Multi Threading</li>
 * <li>Multiple class loader : not taken care here</li>
 * <li>Garbase Collection : This was an issue till java 1.2, it was used to
 * remove singleton instance from heap</li>
 * </ul>
 * 
 * @author Mehul Lakhatariya
 *
 */
public class Singleton implements Cloneable, Serializable {

	private static final long serialVersionUID = -1341515571551628713L;

	// volatile make sure the happen-before principle
	// As there are chances that JVM may return half cooked object if not mark
	// volatile
	private static volatile Singleton INSTANCE;

	private Singleton() {
		// This check to prevent creating object using reflection.
		if (INSTANCE != null) {
			throw new RuntimeException("Operation not supported. Please use getInstance()");
		}
		System.out.println("Creating instance..");
	}

	public static Singleton getInstance() {
		// Double locking is mainly to handle multi-threading environment along with
		// volatile
		if (INSTANCE == null) {
			synchronized (Singleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton();
				}
			}
		}
		return INSTANCE;
	}

	/**
	 * Another way to create Singleton object, which will work in multi-threading
	 * environment and also support lazy loading
	 * 
	 * @return
	 */
	public static Singleton getSingleton() {
		return Holder.INSTANCE;
	}

	static class Holder {
		private static Singleton INSTANCE = new Singleton();
	}

	// This will prevent cloning this object
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Operation not supported. Please use getInstance()");
	}

	// This will prevent serialization to create a new instance
	private Object readResolve() throws ObjectStreamException {
		return INSTANCE;
	}
}
