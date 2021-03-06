package com.mehul.multithreading;

/**
 * @author Mehul
 *
 */
public class ProducerConsumer {

	public static void main(String[] args) {
		CustomQueue queue = new CustomQueue();
		new Consumer(queue);
		new Producer(queue);
	}
}

class CustomQueue {
	int number;
	boolean isQueueFull = Boolean.FALSE;

	synchronized void put(int number) {
		if (isQueueFull) {
			try {
				wait();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.number = number;
		System.out.println("Produced Number : " + number);
		isQueueFull = Boolean.TRUE;
		notify();
	}

	synchronized int get() {
		if (!isQueueFull) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consume Number : " + number);
		isQueueFull = Boolean.FALSE;
		notify();
		return number;
	}
}

class Producer implements Runnable {

	CustomQueue queue;

	/**
	 * @param queue
	 */
	public Producer(CustomQueue queue) {
		this.queue = queue;
		new Thread(this).start();
	}

	@Override
	public void run() {
		int number = 1;
		while (true) {
			queue.put(number++);
		}
	}
}

class Consumer implements Runnable {

	CustomQueue queue;

	/**
	 * @param queue
	 */
	public Consumer(CustomQueue queue) {
		this.queue = queue;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			queue.get();
		}
	}
}