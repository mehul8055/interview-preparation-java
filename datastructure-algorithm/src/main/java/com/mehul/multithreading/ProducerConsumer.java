package com.mehul.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Mehul Lakhatariya
 *
 */
public class ProducerConsumer {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(4);
		usingArrayBlockingQueue(service);
		usingBlockingQueueWithLock(service);
		usingBlockingQueueWithWaitNotify(service);
	}

	private static void usingArrayBlockingQueue(ExecutorService service) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
		service.execute(new Producer(queue));
		service.execute(new Producer(queue));
		service.execute(new Consumer(queue));
		service.execute(new Consumer(queue));
	}

	private static void usingBlockingQueueWithLock(ExecutorService service) {
		BlockingQueueWithLock<Integer> queue = new BlockingQueueWithLock<Integer>(5);
		service.execute(new ProducerWithLock(queue));
		service.execute(new ProducerWithLock(queue));
		service.execute(new ConsumerWithLock(queue));
		service.execute(new ConsumerWithLock(queue));
	}

	private static void usingBlockingQueueWithWaitNotify(ExecutorService service) {
		BlockingQueueWithWaitNotify<Integer> queue = new BlockingQueueWithWaitNotify<Integer>(5);
		service.execute(new ProducerWithWaitNotify(queue));
		service.execute(new ProducerWithWaitNotify(queue));
		service.execute(new ConsumerWithWaitNotify(queue));
		service.execute(new ConsumerWithWaitNotify(queue));
	}
}

class Producer implements Runnable {
	private BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			int nextInt = new Random().nextInt();
			queue.add(nextInt);
			System.out.println("Produced using ArrayBlockingQueue :: " + nextInt);
		}
	}
}

class Consumer implements Runnable {
	private BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Integer value = queue.take();
				System.out.println("Consumed using ArrayBlockingQueue :: " + value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

class ProducerWithLock implements Runnable {
	private BlockingQueueWithLock<Integer> queue;

	public ProducerWithLock(BlockingQueueWithLock<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			int nextInt = new Random().nextInt();
			queue.add(nextInt);
			System.out.println("Produced using BlockingQueueWithLock :: " + nextInt);
		}
	}
}

class ConsumerWithLock implements Runnable {
	private BlockingQueueWithLock<Integer> queue;

	public ConsumerWithLock(BlockingQueueWithLock<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			Integer value = queue.take();
			System.out.println("Consumed using BlockingQueueWithLock :: " + value);
		}
	}
}

class ProducerWithWaitNotify implements Runnable {
	private BlockingQueueWithWaitNotify<Integer> queue;

	public ProducerWithWaitNotify(BlockingQueueWithWaitNotify<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			int nextInt = new Random().nextInt();
			queue.add(nextInt);
			System.out.println("Produced using BlockingQueueWithWaitNotify :: " + nextInt);
		}
	}
}

class ConsumerWithWaitNotify implements Runnable {
	private BlockingQueueWithWaitNotify<Integer> queue;

	public ConsumerWithWaitNotify(BlockingQueueWithWaitNotify<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			Integer value = queue.take();
			System.out.println("Consumed using BlockingQueueWithWaitNotify :: " + value);
		}
	}
}