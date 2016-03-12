import java.util.LinkedList;

/**
 * This is an implementation of Box with a single element for message
 * communication between threads.
 * 
 * @author Stanislav
 *
 */
public class Box {
	private String[] messages;
	private int maxQueueSize;
	private int elementsIn;
	private int pop, push;

	/**
	 * Initialize isEmpty to true, since none has written yet
	 */
	Box() {
		this.messages = new String[maxQueueSize];
		this.maxQueueSize = 10;
		this.pop = 0;
		this.push = 0;
		this.elementsIn = 0;
	}

	/**
	 * Get the message from the queue and free the queue
	 * 
	 * @return
	 */
	public synchronized String take() {
		while (this.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("oops..");
			}
		}
		String message = this.pop();
		notifyAll();
		return message;
	}

	private String pop() {
		String message = this.messages[this.pop];
		this.pop = this.pop++ % this.maxQueueSize;
		this.elementsIn--;
		return message;
	}

	private boolean isEmpty() {
		return this.elementsIn == 0;
	}

	/**
	 * Assign a message to the queue string
	 * 
	 * @param message
	 */
	public synchronized void put(String message) {
		while (this.hasSpace()) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("oops..");
			}
		}
		this.push(message);
		notifyAll();
	}

	private void push(String message) {
		this.messages[this.push] = message;
		this.push = this.push++ % this.maxQueueSize;
		this.elementsIn++;
	}

	private boolean hasSpace() {
		return (this.maxQueueSize - elementsIn - 1) > 0;
	}
}
