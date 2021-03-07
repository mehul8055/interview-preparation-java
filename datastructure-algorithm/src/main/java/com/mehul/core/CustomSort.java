package com.mehul.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input : { "fizz", "fizz", "fizz", "buzz", "buzz", "abc", "abc" }
 * Output : 
 * fizz 3
 * buzz 2
 * abc 2
 * 
 * @author Mehul
 *
 */
public class CustomSort {

	public static void main(String[] args) {
		String[] transactions = { "fizz", "fizz", "fizz", "buzz", "buzz", "abc", "abc" };
		displaySortedGroup(transactions);
		String[] transactions1 = { "ab", "ab", "pq", "pq", "xy", "xy", "xy" };
		displaySortedGroup(transactions1);
	}

	static void displaySortedGroup(String[] transactions) {
		
		Map<String, Integer> dataMap = new HashMap<>();
		for (String txn : transactions) {
			if (dataMap.get(txn) != null) {
				Integer count = dataMap.get(txn);
				dataMap.put(txn, count + 1);
			} else {
				dataMap.put(txn, 1);
			}
		}
		
		List<Data> dataList = new ArrayList<>();
		for (String txn : dataMap.keySet()) {
			dataList.add(new Data(txn, dataMap.get(txn)));
		}
		Collections.sort(dataList, new CountComparator().thenComparing(new TransactionComparator()));
		dataList.forEach(data -> System.out.println(data));
	}
}

class Data {
	private String transaction;
	private Integer count;

	/**
	 * @param transaction
	 * @param count
	 */
	public Data(String transaction, Integer count) {
		super();
		this.transaction = transaction;
		this.count = count;
	}

	/**
	 * @return the transaction
	 */
	public String getTransaction() {
		return transaction;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	@Override
	public String toString() {
		return transaction + " " + count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transaction == null) ? 0 : transaction.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (transaction == null) {
			if (other.transaction != null)
				return false;
		} else if (!transaction.equals(other.transaction))
			return false;
		return true;
	}
}

class TransactionComparator implements Comparator<Data> {
	@Override
	public int compare(Data o1, Data o2) {
		return o1.getTransaction().compareTo(o2.getTransaction());// Ascending Sort on transaction
	}
}

class CountComparator implements Comparator<Data> {
	@Override
	public int compare(Data o1, Data o2) {
		return o2.getCount().compareTo(o1.getCount()); // Descending Sort on count
	}
}