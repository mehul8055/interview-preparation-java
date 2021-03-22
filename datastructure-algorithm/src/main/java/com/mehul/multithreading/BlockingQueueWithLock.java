package com.mehul.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * This will Demonstrate the Custom Blocking queue using lock
 * 
 * @author Mehul Lakhatariya
 *
 */
public class BlockingQueueWithLock<E> {

	private Lock lock = new ReentrantLock(true);
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();

	private int max = 5;
	private Queue<E> queue;

	/**
	 * @param max
	 */
	public BlockingQueueWithLock(int max) {
		this.max = max;
		queue = new LinkedList<>();
	}

	public void add(E e) {
		lock.lock();
		try {
			while (queue.size() == max) {
				notFull.await();
			}
			queue.add(e);
			// Once we added element into queue meaning that it is not empty for sure
			// so signaling the same
			notEmpty.signalAll();
			Thread.sleep(10);
		} catch (Exception e2) {
			lock.unlock();
		}

	}

	public E take() {
		lock.lock();
		E element = null;
		try {
			while (queue.size() == 0) {
				notEmpty.await();
			}
			element = queue.remove();
			// Once remove element from queue meaning that its not full
			// so signaling the same
			notFull.signalAll();
		} catch (Exception e2) {
			lock.unlock();
		}
		return element;
	}
}
