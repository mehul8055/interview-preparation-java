package com.mehul.multithreading;

/**
 * @author Mehul
 *
 */
public class EvenOdd {

	public static void main(String[] args) {
		Shared shared = new Shared();
		new Even(shared, 30);
		new Odd(shared, 30);
	}

	static class Even extends Thread {
		private Shared shared;
		private int maxEvenNumber;

		/**
		 * @param shared
		 * @param maxEvenNumber
		 */
		public Even(Shared shared, int maxEvenNumber) {
			this.shared = shared;
			this.maxEvenNumber = maxEvenNumber;
			start();
		}

		public void run() {
			int minEvenNumber = 2;
			try {
				while (minEvenNumber <= maxEvenNumber) {
					shared.printEvenNumber(minEvenNumber);
					minEvenNumber = minEvenNumber + 2;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class Odd extends Thread {
		private Shared shared;
		private int maxOddNumber;

		/**
		 * @param shared
		 * @param maxEvenNumber
		 */
		public Odd(Shared shared, int maxOddNumber) {
			this.shared = shared;
			this.maxOddNumber = maxOddNumber;
			start();
		}

		public void run() {
			int minOddNumber = 1;
			try {
				while (minOddNumber <= maxOddNumber) {
					shared.printOddNumber(minOddNumber);
					minOddNumber = minOddNumber + 2;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class Shared {
		boolean printOdd = Boolean.FALSE;

		synchronized void printOddNumber(int number) throws InterruptedException {
			while (printOdd) {
				wait();
			}
			printOdd = Boolean.TRUE;
			Thread.currentThread().setName("Odd Thread :: ");
			System.out.println(Thread.currentThread().getName() + number);
			notify();
		}

		synchronized void printEvenNumber(int number) throws InterruptedException {
			while (!printOdd) {
				wait();
			}
			printOdd = Boolean.FALSE;
			Thread.currentThread().setName("Even Thread :: ");
			System.out.println(Thread.currentThread().getName() + number);
			notify();
		}

	}
}
