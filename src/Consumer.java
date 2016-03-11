import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author Stanislav
 *
 */
public class Consumer implements Runnable {

	BlockingQueue<String> bq;

	/**
	 * 
	 * @param box
	 */
	public Consumer(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	/**
	 * 
	 */
	public void run() {
		Random rnd = new Random();
		try {
			for (String message = bq.take(); !message.equals("DONE"); message = bq.take()) {
				try {
					Thread.sleep(rnd.nextInt(350));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(message);

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
