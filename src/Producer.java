import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author Stanislav
 *
 */
public class Producer implements Runnable {

	/**
	 * 
	 */
	BlockingQueue<String> bq;

	/**
	 * 
	 * @param box
	 */
	public Producer(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	/**
	 * 
	 */
	public void run() {
		try {
			Random rnd = new Random();
			String[] messages = { "Once", "upon", "a", "time", "there", "was", "a", "village", "hidden", "in", "the",
					"mountains", "of", "BlueBunny." };
			for (String message : messages) {
				Thread.sleep(rnd.nextInt(350));
				bq.put(message);
			}
			bq.put("DONE");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
