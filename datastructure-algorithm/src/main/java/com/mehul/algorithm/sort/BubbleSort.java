package com.mehul.algorithm.sort;

/**
 * Bubble Sort is work as follows
 * <ul>
 * <li>This is in-place algorithm</li>
 * <li>It has time complexity as O(n square)</li>
 * <li>Each element compare with next element and swap current element if it is
 * bigger than next one</li>
 * <li>In each iteration last element is in correct position so we are
 * decreasing last index by one</li>
 * <li>This is stable sort Algorithm meaning if two elements are equals it will
 * not swap</li>
 * <li>Initial : [23, 11, -34, 4, 55, 6, -22]</li>
 * <li>Iteration 1 : [11, 23, -34, 4, 55, 6, -22]</li>
 * <li>Iteration 2 : [11, -34, 23, 4, 55, 6, -22]</li>
 * <li>Iteration 3 : [11, -34, 4, 23, 55, 6, -22]</li>
 * <li>Iteration 4 : [11, -34, 4, 23, 55, 6, -22]</li>
 * <li>Iteration 5 : [11, -34, 4, 23, 6, 55, -22]</li>
 * <li>Iteration 6 : [11, -34, 4, 23, 6, -22, 55]</li>
 * <li>It finished with first pass and continue for next phase till sorted.</li>
 * </ul>
 * 
 * @author Mehul Lakhatariya
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		SortUtils sortUtils = new SortUtils();

		int[] array = { 23, 11, -34, 4, 55, 6, -22 };

		sortUtils.display(array, "Unsorted Data : ");
		for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			for (int i = 0; i < lastUnsortedIndex; i++) {
				if (array[i] > array[i+1]) {
					sortUtils.swap(array, i, i+1);
				}
				sortUtils.display(array, "Iteration " + (i + 1) + " :");
			}
		}
		sortUtils.display(array, "Sorted Data");
	}
}
