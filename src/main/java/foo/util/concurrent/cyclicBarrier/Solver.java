package foo.util.concurrent.cyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// java doc foo

public class Solver {

	final int n;
	final float[][] data;
	final CyclicBarrier barrier;

	class Worker implements Runnable {

		int myRow;

		Worker(int row) {
			myRow = row;
		}

		@Override
		public void run() {

			while (!done()) {
				
				// processRow(myRow);

				try {
					barrier.await();
				} catch (InterruptedException ex) {
					return;
				} catch (BrokenBarrierException ex) {
					return;
				}
			}
		}

		boolean done() {
			return false;
		}
	}

	public Solver(float[][] matrix) {

		data = matrix; // 矩阵
		n = matrix.length;

		Runnable barrierAction = new Runnable() {
			@Override
			public void run() {
				// mergeRows(...);
			}
		};
		barrier = new CyclicBarrier(n, barrierAction);

		List<Thread> threads = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			Thread thread = new Thread(new Worker(i));
			threads.add(thread);
			thread.start();
		}

		// wait until done
		for (Thread thread : threads)
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}