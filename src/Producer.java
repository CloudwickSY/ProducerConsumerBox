import java.util.Random;

/**
 * 
 * @author Stanislav
 *
 */
public class Producer implements Runnable {

	/**
	 * 
	 */
	Box box;

	/**
	 * 
	 * @param box
	 */
	public Producer(Box box) {
		this.box = box;
	}

	/**
	 * 
	 */
	public void run() {
		Random rnd = new Random();
		String[] messages = { "Once", "upon", "a", "time", "there", "was", "a", "village", "hidden", "in", "the",
				"mountains", "of", ".." };
		for (String message : messages) {
			try {
				Thread.sleep(rnd.nextInt(350));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			box.put(message);
		}
		box.put("DONE");
	}
}
