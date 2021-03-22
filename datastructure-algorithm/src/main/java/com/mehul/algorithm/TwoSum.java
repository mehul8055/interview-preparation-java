package com.mehul.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * <ul>
 * <li>Example 1: <br>
 * Input: nums = [2,7,11,15], target = 9<br>
 * Output: [0,1]<br>
 * Output: nums[0] + nums[1] == 9, we return [0, 1].</li>
 * <li>Example 2: <br>
 * Input: nums = [3,2,4], target = 6 <br>
 * Output: [1,2]</li>
 * <li>Example 3:<br>
 * Input: nums = [3,3], target = 6 <br>
 * Output: [0,1]</li>
 * </ul>
 * 
 * @author Mehul Lakhatariya
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] data = new int[] { 2, 3, 5, 1, 6 };

		int sum = 7;
		int[] solution = null;

		Map<Integer, Integer> cache = new HashMap<>();
		for (int i = 0; i < data.length; i++) {
			int temp = sum - data[i];
			if (cache.containsKey(temp)) {
				solution = new int[] { cache.get(temp), i };
				break;
			}
			cache.put(data[i], i);
		}

		System.out.println(solution[0] + " " + solution[1]);
	}
}
