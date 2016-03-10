/**
 * 
 * @author Stanislav
 *
 */
public class Main {
	public static void main(String[] args) {
		Box b = new Box();
		int threadCount = 10;
		Thread[] prodPool = new Thread[threadCount];
		Thread[] custPool = new Thread[threadCount];

		for (int i = 0; i < threadCount; i++) {
			prodPool[i] = new Thread(new Producer(b));
			custPool[i] = new Thread(new Consumer(b));
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
