package com.mehul.algorithm;

/**
 * @author Mehul
 *
 */
public class BalancedBracket {

	public static void main(String[] args) {
		String brackets = "{{[[()()[]]][[]()]()()}}";
		System.out.println(isBalanced(brackets) ? "Balanced!" : "Not Balanced!");
		String brackets1 = "){{[[[]]][[]]}}(";
		System.out.println(isBalanced(brackets1) ? "Balanced!" : "Not Balanced!");
	}

	public static boolean isBalanced(String str) {
		if (null == str || ((str.length() % 2) != 0)) {
			return false;
		} else {
			char[] ch = str.toCharArray();
			for (char c : ch) {
				if (!(c == '{' || c == '[' || c == '(' || c == '}' || c == ']' || c == ')')) {
					return false;
				}

			}
		}

		while (str.contains("()") || str.contains("[]") || str.contains("{}")) {
			str = str.replaceAll("\\(\\)", "").replaceAll("\\[\\]", "").replaceAll("\\{\\}", "");
		}
		return (str.length() == 0);
	}
}
