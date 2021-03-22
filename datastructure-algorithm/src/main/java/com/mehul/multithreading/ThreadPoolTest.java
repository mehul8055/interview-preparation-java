package com.mehul.multithreading;

/**
 * 
 * @author Mehul Lakhatariya
 *
 */
public class ThreadPoolTest {

	public static void main(String[] args) {
		ThreadPool threadPool = new ThreadPool(3);
		threadPool.execute(new Task("Task 1"));
		threadPool.execute(new Task("Task 2"));
		threadPool.execute(new Task("Task 3"));
		threadPool.execute(new Task("Task 4"));
		threadPool.execute(new Task("Task 5"));
		threadPool.execute(new Task("Task 6"));
		threadPool.execute(new Task("Task 7"));
		threadPool.execute(new Task("Task 8"));
		threadPool.execute(new Task("Task 9"));
		threadPool.execute(new Task("Task 10"));
		threadPool.execute(new Task("Task 11"));
		threadPool.execute(new Task("Task 12"));

		threadPool.shutdown();

		threadPool.execute(new Task("Task 13"));
	}
}
