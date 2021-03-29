package com.mehul.algorithm.sort;

import java.util.Arrays;
import java.util.Optional;

/**
 * This is an utility class to help sorting.
 * 
 * @author Mehul
 *
 */
public class SortUtils {

	/**
	 * It will swap element in provided integer array based on array index provided
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	public void swap(int[] array, int i, int j) {
		if (array[i] == array[j]) {
			return;
		}
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * It will print all element in provided array
	 * 
	 * @param array
	 * @param message
	 */
	public void display(int[] array, String message) {
		
		Optional<String> dataOptional = Arrays.stream(array).mapToObj(ele -> "" + ele)
				.reduce((ele1, ele2) -> ele1.concat(", " + ele2));

		System.out.println(message + "[" + dataOptional.get() + "]");
	}
}
