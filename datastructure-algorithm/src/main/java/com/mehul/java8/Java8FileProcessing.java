package com.mehul.java8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

/**
 * @author Mehul
 *
 */
public class Java8FileProcessing {

	public static void main(String[] args) throws IOException, URISyntaxException {
		processEmployee();
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
}
