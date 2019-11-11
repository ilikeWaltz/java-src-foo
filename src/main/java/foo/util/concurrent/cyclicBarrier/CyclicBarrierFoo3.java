package foo.util.concurrent.cyclicBarrier;

import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierFoo3 {

	public static void main(String[] args) {

		ConcurrentHashMap<String, Integer> scoreMap = new ConcurrentHashMap<String, Integer>();

		int n = 3;
		Runnable lastWorkToDo = new Runnable() {
			@Override
			public void run() {
				int result = 0;

				Set<Entry<String, Integer>> entrySet = scoreMap.entrySet();
				for (Entry<String, Integer> s : entrySet)
					result += s.getValue();

				System.out.println("avg score:" + (result / n));
			}
		};

		// TODO
		CyclicBarrier cyclicBarrier = new CyclicBarrier(n, lastWorkToDo);

		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < n; i++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					int score = (int) (Math.random() * 40 + 60);
					scoreMap.put(Thread.currentThread().getName(), score);
					System.out.println(Thread.currentThread().getName() + ", score:" + score);
					try {
						// TODO
						cyclicBarrier.await();
						System.out.println(score);
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			});
		}
		threadPool.shutdown();
	}

}