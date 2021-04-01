package com.mehul.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * This class will create In-Memory-Cache using ReadWriteLock, which will work
 * for multiple thread concurrently.
 * 
 * @author Mehul Lakhatariya
 *
 */
public class ConcurrentMap<Key, Value> {

	private Map<Key, Value> cache = new HashMap<>();
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	private Lock readLock = lock.readLock();
	private Lock writeLock = lock.writeLock();

	public Value get(Key key) {
		try {
			readLock.lock();
			return cache.get(key);
		} finally {
			readLock.notifyAll();
		}
	}

	public Value put(Key key, Value value) {
		try {
			writeLock.lock();
			return cache.put(key, value);
		} finally {
			writeLock.notifyAll();
		}
	}

	public int size() {
		try {
			readLock.lock();
			return cache.size();
		} finally {
			readLock.notifyAll();
		}
	}
}
