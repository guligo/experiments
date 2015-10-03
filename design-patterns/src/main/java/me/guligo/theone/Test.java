package me.guligo.theone;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demonstrates singleton design pattern and conducts basic experiment to prove
 * thread-safety of instantiation method.
 * 
 * @author guligo
 */
public class Test {

	private final static int T = 100;

	public static void main(String[] args) throws InterruptedException {
		// prepare data structure for storing the result
		final Set<String> instances = Collections
				.synchronizedSet(new HashSet<String>());

		// start up threads
		final Thread[] threads = new Thread[T];
		final AtomicInteger lock = new AtomicInteger(0);
		for (int i = 0; i < T; i++) {
			threads[i] = new Thread() {
				@Override
				public void run() {
					synchronized (lock) {
						try {
							lock.addAndGet(1);
							// barrier
							lock.wait();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					instances.add(TheOne.getInstance().saySomething());
				}
			};
			threads[i].start();
		}

		// wait until all threads have reached the barrier
		while (lock.get() != T) {
			// do nothing
		}

		// notify all threads waiting at the barrier
		synchronized (lock) {
			lock.notifyAll();
		}

		// wait until all threads are dead
		for (Thread thread : threads) {
			thread.join();
		}

		// check results
		assert instances.size() != 0 : "Ouch! Something went terribly wrong";
		assert instances.size() > 1 : "More than one instance of an object spotted";
		System.out.println(instances);
	}

}
