package com.mehul.multithreading;

/**
 * This class will demonstrate the thread communication and print Ping-Pong
 * alternatively with two thread
 * 
 * @author Mehul Lakhatariya
 *
 */
public class PingPong {

	public static void main(String[] args) {
		Object lock = new Object();
		new Thread(new PingPongThread("Ping", lock)).start();
		new Thread(new PingPongThread("Pong", lock)).start();
	}
}

/**
 * 
 * @author Mehul
 *
 */
class PingPongThread implements Runnable {

	private String msg;
	private Object lock;

	public PingPongThread(String msg, Object lock) {
		this.msg = msg;
		this.lock = lock;
	}

	@Override
	public void run() {
		/**
		 * This synchronized block will acquire a lock on object passed in constructor
		 */
		synchronized (lock) {
			for (int i = 0; i < 5; i++) {
				System.out.println(msg);
				lock.notify();
				try {
					// Thread.sleep(500);
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			/**
			 * This notifyAll will terminate waiting thread else program will go forever for
			 * wait
			 */
			lock.notifyAll();
		}
	}
}
