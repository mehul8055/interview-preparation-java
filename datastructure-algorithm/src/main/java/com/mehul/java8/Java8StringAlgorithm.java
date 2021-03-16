package com.mehul.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is used to Perform String related algorithm, Some algorithm are as
 * follows
 * <ul>
 * <li>Reverse word in String</li>
 * <li>Check words are anagram or not</li>
 * <li>Find duplicate characters and its occurrence in String</li>
 * </ul>
 * 
 * @author Mehul
 *
 */
public class Java8StringAlgorithm {

	public static void main(String[] args) {
		String reverse = reverseWordInSentance("This is my first line");
		System.out.println(reverse);

		boolean isStringAnagram = isStringsAnagrams("listen", "silent");
		System.out.println(isStringAnagram ? "Anagram" : "Not Anagram");

		findDuplicateCharInString("programming");
	}

	private static String reverseWordInSentance(String sentance) {

		List<String> words = Arrays.asList(sentance.split("\\s+"));
		Collections.reverse(words);
		String reverse = words
				.stream()
				.reduce(" ", (word1, word2) -> word1.concat(" " + word2))
				.trim();

		return reverse;
	}

	private static boolean isStringsAnagrams(String firstWord, String secondWord) {

		if (firstWord != null && secondWord != null && firstWord.length() != secondWord.length()) {
			return false;
		}
		
		String mergeString = firstWord.concat(secondWord).toLowerCase();

		long count = mergeString
			.chars()
			.mapToObj(ch -> (char) ch)
			.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
			.values()
			.stream()
			.filter(charCount -> charCount == 2)
			.count();

		return count == firstWord.length();

	}

	private static void findDuplicateCharInString(String word) {
		//This will create IntStream of char
		word.chars()
			//Mapping to Object from int -> char -> Character [AutoBoxing]
			.mapToObj(ch -> (char)ch)
			//Group each Character and count its occurrence : Map<Characte, Long>
			.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
			//Creating entryset <Map.Entry<Character, Long>> 
			.entrySet()
			.stream()
			//Mapping this to "Character Character_count"
			.map(entry -> entry.getKey() + " " +entry.getValue())
			//Filtering whose character count is more that 1 
			.filter(ch -> !ch.endsWith("1"))
			.forEach(System.out::println);
	}
}
