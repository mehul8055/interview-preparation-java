package com.mehul.core;

/**
 * It Demonstrate the AutoClosable interface and created custom resource to use
 * in try-with-resource, try block without catch or even finally
 * 
 * @author Mehul
 *
 */
public class ExceptionUnderstanding {

	public static void main(String[] args) {
		System.out.println(getValue());
	}

	public static String getValue() {
		try (MyResource resource = new MyResource()) {
			return "Value";
		} 
	}
}

class MyResource implements AutoCloseable {

	@Override
	public void close() {
		try {
			System.out.println("Closing my resources..");
		} catch (Exception e) {
		}
	}

}
