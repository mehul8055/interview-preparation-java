package com.mehul.algorithm;

/**
 * @author Mehul Lakhatariya
 *
 */
public class RecursionDynamicPrograming {
	public static void main(String[] args) {
		RecursionDynamicPrograming recursion = new RecursionDynamicPrograming();
		Long[] memoize = new Long[10000];
		System.out.println(recursion.fibonacci(35, memoize));
	}

	private Long fibonacci(int n, Long[] memoize) {
		if(memoize[n] != null) {
			return memoize[n];
		}
		if(n == 1 || n == 2) {
			return 1l;
		}
		Long result = fibonacci(n-1, memoize) + fibonacci(n-2, memoize);
		memoize[n] = result;
		return result;
	}
}
