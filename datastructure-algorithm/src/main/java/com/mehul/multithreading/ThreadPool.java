package com.mehul.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This class will demonstrate the custom thread pool functionality it is
 * similar to Executer Service framework but created our own.
 * 
 * @author Mehul Lakhatariya
 *
 */
public class ThreadPool {

	private BlockingQueue<Runnable> queue;

	private boolean isShutdownInitiated = Boolean.FALSE;

	/**
	 * @param queue
	 * @param poolSize
	 */
	public ThreadPool(int poolSize) {
		queue = new LinkedBlockingQueue<>(poolSize);

		for (int i = 1; i <= poolSize; i++) {
			MyThread thread = new MyThread(queue, this);
			thread.setName("Thread " + i);
			System.out.println("Thread-" + i + " created in thread pool");
			thread.start();
		}
	}

	public synchronized void execute(Runnable task) {
		if (isShutdownInitiated) {
			System.out.println("Threadpool is already shutdown so, new task is not accepted!");
			return;
		}
		try {
			queue.put(task);
			System.out.println("Task is added!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void shutdown() {
		System.out.println("Shutting Down Threadpool!");
		isShutdownInitiated = Boolean.TRUE;
	}

	private boolean isShutdownInitiated() {
		return isShutdownInitiated;
	}

	static class MyThread extends Thread {

		private BlockingQueue<Runnable> queue;
		private ThreadPool threadPool;

		/**
		 * @param queue
		 * @param threadPool
		 */
		public MyThread(BlockingQueue<Runnable> queue, ThreadPool threadPool) {
			this.queue = queue;
			this.threadPool = threadPool;
		}

		@Override
		public void run() {
			try {
				while (true) {
					Runnable task = queue.take();
					task.run();
					if (threadPool.isShutdownInitiated() && queue.size() == 0) {
						this.interrupt();
						Thread.sleep(1);
					}
				}
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " is Stopped now.");
			}
		}
	}
}