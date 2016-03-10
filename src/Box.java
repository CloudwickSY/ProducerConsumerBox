import java.util.LinkedList;

/**
 * This is an implementation of Box with a single element for 
 * message communication between threads.
 * @author Stanislav
 *
 */
public class Box {
	private LinkedList <String> messages;
	int maxQueueSize;
	
	/**
	 * Initialize isEmpty to true, since none has written yet
	 */
	Box(){
		this.messages = new LinkedList<String>();
		this.maxQueueSize = 10;
	}
	
	/**
	 * Get the message from the queue and free the queue
	 * @return
	 */
	public synchronized String take(){
		while(messages.isEmpty()){
			try{
				wait();
			}catch (InterruptedException e){
				System.out.println("oops..");
			}
		}
		String message = messages.pop();
		notifyAll();
		return message;
	}
	
	/**
	 * Assign a message to the queue string
	 * @param message
	 */
	public synchronized void put(String message){
		while(messages.size()>=maxQueueSize){
			try{
				wait();
			}catch (InterruptedException e){
				System.out.println("oops..");
			}
		}
		this.messages.push(message);
		notifyAll();
	}
}
