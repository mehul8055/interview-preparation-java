package com.mehul.multithreading;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * This will Demonstrate the Custom Blocking queue using Wait Notify
 * 
 * @author Mehul
 *
 */
public class BlockingQueueWithWaitNotify<E> {

	private Object notEmpty = new Object();
	private Object notFull = new Object();

	private int max = 5;
	private Queue<E> queue;

	/**
	 * @param max
	 */
	public BlockingQueueWithWaitNotify(int max) {
		this.max = max;
		queue = new LinkedList<>();
	}

	public synchronized void add(E e) {
		try {
			while (queue.size() == max) {
				// Not Full object needs to wait as queue is full
				notFull.wait();
			}
			queue.add(e);
			// Once we added element into queue meaning that it is not empty for sure
			// so signaling the same
			notEmpty.notifyAll();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

	public synchronized E take() {
		E element = null;
		try {
			while (queue.size() == 0) {
				// Not Empty Object needs to wait as queue is empty
				notEmpty.wait();
			}
			element = queue.remove();
			// Once remove element from queue meaning that its not full
			// so signaling the same
			notFull.notifyAll();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		return element;
	}

}
