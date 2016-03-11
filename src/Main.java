import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author Stanislav
 *
 */
public class Main {
	public static void main(String[] args) {
		int threadCount = 10;
		int bqSize = 10;
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(bqSize);
		Thread[] prodPool = new Thread[threadCount];
		Thread[] custPool = new Thread[threadCount];

		for (int i = 0; i < threadCount; i++) {
			prodPool[i] = new Thread(new Producer(bq));
			custPool[i] = new Thread(new Consumer(bq));
			prodPool[i].start();
			custPool[i].start();
		}

		try {
			for (int i = 0; i < threadCount; i++) {
				custPool[i].join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
