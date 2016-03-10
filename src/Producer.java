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
		String[] messages = { "Once", "upon", "a", "time", "there", "was", "a", "village", "hidden", "in", "the",
				"mountains", "of", ".." };
		for (String message : messages) {
			box.put(message);
		}
		box.put("DONE");
	}
}
