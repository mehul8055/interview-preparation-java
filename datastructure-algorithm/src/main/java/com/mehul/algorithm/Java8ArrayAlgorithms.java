package com.mehul.algorithm;

import java.util.Arrays;

/**
 * 
 * @author Mehul Lakhatariya
 *
 */
public class Java8ArrayAlgorithms {

	public static void main(String[] args) {
		findMissingNumber();
	}

	/**
	 * Finding single missing Number from 1 to 10
	 * 
	 * @param start
	 * @param end
	 */
	private static void findMissingNumber() {

		int[] data = { 1, 2, 3, 4, 5, 7, 8, 9, 10 };
		int n = 10;

		int targetSum = n * (n + 1) / 2;

		System.out.println("Target Sum :: " + targetSum);

		int actualDataSum = Arrays.stream(data).sum();

		int missingNumber = targetSum - actualDataSum;

		System.out.println("Missing Number :: " + missingNumber);
	}
	
}
