package com.mehul.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class will demonstrate CountDownLatch, 
 * There are 3 development tasks and 2 QA tasks We need to make sure that 
 * QA tasks will start right after Development tasks are over
 * 
 * @author Mehul Lakhatariya
 *
 */
public class CountDownLatchExample {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new DevelopmentTask("Development Task 1", latch));
		service.execute(new DevelopmentTask("Development Task 2", latch));
		service.execute(new DevelopmentTask("Development Task 3", latch));

		try {
			latch.await();
			System.out.println("QA Tasks was waiting to finished Development tasks.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		service.execute(new DevelopmentTask("QA Task 1", latch));
		service.execute(new DevelopmentTask("QA Task 2", latch));

		service.shutdown();
	}
}

class DevelopmentTask implements Runnable {

	private String name;
	private CountDownLatch latch;

	/**
	 * @param name
	 * @param latch
	 */
	public DevelopmentTask(String name, CountDownLatch latch) {
		this.name = name;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			System.out.println("Started " + name);
			Thread.sleep(3000);
			System.out.println("Completed " + name);
			latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class QATask implements Runnable {

	private String name;

	/**
	 * @param name
	 * @param latch
	 */
	public QATask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println("Started " + name);
			Thread.sleep(2000);
			System.out.println("Completed " + name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}