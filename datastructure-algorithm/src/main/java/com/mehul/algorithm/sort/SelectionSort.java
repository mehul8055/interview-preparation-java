package com.mehul.algorithm.sort;

/**
 * Bubble Sort is work as follows
 * <ul>
 * <li>This is in-place algorithm</li>
 * <li>It has time complexity as O(n square)</li>
 * <li>Each element compare with next element and check if current index value
 * is bigger if so update temporary variable which hold index of largest
 * element</li>
 * <li>In each iteration last element is in correct position so we are
 * decreasing last index by one</li>
 * <li>This is unstable sort Algorithm meaning if two elements are equals it
 * will not swap</li>
 * <li>Initial : [23, 11, -34, 4, 55, 6, -22]</li>
 * <li>Iteration 1 :[23, 11, -34, 4, -22, 6, 55]</li>
 * <li>Iteration 2 :[6, 11, -34, 4, -22, 23, 55]</li>
 * <li>Iteration 3 :[6, -22, -34, 4, 11, 23, 55]</li>
 * <li>Iteration 4 :[4, -22, -34, 6, 11, 23, 55]</li>
 * <li>Iteration 5 :[-34, -22, 4, 6, 11, 23, 55]</li>
 * <li>Iteration 6 :[-34, -22, 4, 6, 11, 23, 55]</li>
 * <li>This is good compare to Bubble Sort as it is not swapping each value
 * rather it hold lard value in temporary variable and at the end of each
 * iteration it will swap with last value.</li>
 * </ul>
 * 
 * @author Mehul Lakhatariya
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		SortUtils sortUtils = new SortUtils();

		int[] array = { 23, 11, -34, 4, 55, 6, -22 };

		sortUtils.display(array, "Unsorted Data : ");
		int iteration = 1;
		for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			int larger = 0;
			for (int i = 1; i <= lastUnsortedIndex; i++) {
				if (array[larger] < array[i]) {
					larger = i;
				}
			}
			sortUtils.swap(array, larger, lastUnsortedIndex);
			sortUtils.display(array, "Iteration " + iteration++ + " :");
		}
		sortUtils.display(array, "Sorted Data");
	}
}
