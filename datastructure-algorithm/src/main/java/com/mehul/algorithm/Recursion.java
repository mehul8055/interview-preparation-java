package com.mehul.algorithm;

/**
 * @author Mehul Lakhatariya
 *
 */
public class Recursion {

	public static void main(String[] args) {
		Recursion recursion = new Recursion();
		System.out.println(recursion.fibonacci(35));
	}

	private int fibonacci(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
}
