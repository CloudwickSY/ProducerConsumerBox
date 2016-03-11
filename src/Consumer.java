import java.util.Random;

/**
 * 
 * @author Stanislav
 *
 */
public class Consumer implements Runnable {

	Box box;

	/**
	 * 
	 * @param box
	 */
	public Consumer(Box box) {
		this.box = box;
	}

	/**
	 * 
	 */
	public void run() {
		Random rnd = new Random();
		for (String message = box.take(); !message.equals("DONE"); message = box.take()) {
			try {
				Thread.sleep(rnd.nextInt(350));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(message);

		}
	}
}
