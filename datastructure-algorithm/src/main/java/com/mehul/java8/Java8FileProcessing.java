package com.mehul.java8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Mehul
 *
 */
public class Java8FileProcessing {

	public static void main(String[] args) throws IOException, URISyntaxException {
		//processEmployee();
		// countWord();
		findLongestLine();
	}

	public static void processEmployee() throws IOException, URISyntaxException {
		// Create Stream of line from file employee.csv located in src/main/resources
		Stream<String> employees = Files.lines(
				Paths.get(ClassLoader.getSystemResource("employee.csv").toURI()),
				StandardCharsets.UTF_8);
		
		IntSummaryStatistics summaryStatistics = employees
			//Skip Header of file 
			.skip(1)
			//Splitting line with comma "," will give an Array of String
			.map(line -> line.split(","))
			//Filter bad data [ Line not having all information ]
			.filter(fields -> fields.length == 5)
			//Map to Age as integer
			.mapToInt(fields -> Integer.parseInt(fields[2]))
			//See summary like IntSummaryStatistics{count=8, sum=626, min=18, average=78.250000, max=90}
			.summaryStatistics();
		System.out.println(summaryStatistics);

		employees.close();
	}

	public static void countWord() throws IOException, URISyntaxException {
		// Create Stream of line from file wordcount.txt located in src/main/resources
		Stream<String> lines = Files.lines(
				Paths.get(ClassLoader.getSystemResource("wordcount.txt").toURI()),
				StandardCharsets.UTF_8);
		
		Map<String, Integer> wordCountMap 
		= lines
			.map(line -> line.split("\\s+"))
			.flatMap(Arrays::stream)
			.collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));

		lines.close();

		System.out.println(wordCountMap);
	}

	public static void findLongestLine() throws IOException, URISyntaxException {
		class Line{
			String line;
			int length;
			/**
			 * @param line
			 * @param length
			 */
			public Line(String line, int length) {
				this.line = line;
				this.length = length;
			}
			
			public int getLength() {
				return length;
			}
			
			public String getLine() {
				return line;
			}
		}
		
		// Create Stream of line from file wordcount.txt located in src/main/resources
		Stream<String> lines = Files.lines(
				Paths.get(ClassLoader.getSystemResource("wordcount.txt").toURI()),
				StandardCharsets.UTF_8);
		
		Optional<Line> longestLine = lines
			.map(line -> new Line(line, line.length()))
			.max(Comparator.comparingInt(line -> line.getLength()));

		System.out.println(longestLine.get().getLine());
		lines.close();
	}
}
