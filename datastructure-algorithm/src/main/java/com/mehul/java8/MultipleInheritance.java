package com.mehul.java8;

/**
 * This will demonstrated multiple inheritance
 * 
 * @author Mehul Lakhatariya
 *
 */
public class MultipleInheritance implements First, Second, Third {

	@Override
	public void print() {
		System.out.println("Printing...");
	}

	@Override
	public void print(int value) {
		System.out.println("Printing Value.." + value);
	}

	public static void main(String[] args) {
		First first = new MultipleInheritance();
		first.print();
		first.defaultMathodFirst();

		Second second = new MultipleInheritance();
		second.print();
		Second.staticMethodSecond();
		second.defaultMathodSecond();
		printUsingLambda(() -> System.out.println("Printing from Lambda.."));

	}

	static void printUsingLambda(Second second) {
		second.print();
	}
}

/**
 * 
 * @author Mehul
 *
 */
//This is not a functional interface
interface First {

	void print();

	void print(int value);

	default void defaultMathodFirst() {
		System.out.println("Printing from default method of First.");
	}

	static void staticMethodSecond() {
		System.out.println("Printing from static method of Second.");
	}
}

/**
 * 
 * @author Mehul
 *
 */
@FunctionalInterface
interface Second extends Third {

	void print();

	boolean equals(Object obj);

	default void defaultMathodSecond() {
		System.out.println("Printing from default method of Second.");
	}

	static void staticMethodSecond() {
		System.out.println("Printing from static method of Second.");
	}
}

@FunctionalInterface
interface Third {

	void print();

}