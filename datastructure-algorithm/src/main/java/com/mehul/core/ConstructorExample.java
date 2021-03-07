package com.mehul.core;

/**
 * 
 * @author Mehul
 *
 */
public class ConstructorExample {
	public static void main(String[] args) {
		Parent p = new Child();
	}
}

class Parent {
	static {
		System.out.println("Parent Static");
	}
	{
		System.out.println("Parent block");
	}

	public Parent() {
		System.out.println("Parent Constroctor");
	}
}

class Child extends Parent {
	static {
		System.out.println("Child Static");
	}
	{
		System.out.println("Child block");
	}

	public Child() {
		System.out.println("Child Constroctor");
	}
}