/**
 * This is an implementation of Box with a single element for 
 * message communication between threads.
 * @author Stanislav
 *
 */
public class Box {
	private String message;
	private boolean isEmpty;
	
	/**
	 * Initialize isEmpty to true, since none has writen yet
	 */
	Box(){
		isEmpty = true;
	}
	
	/**
	 * Get the message from the queue and free the queue
	 * @return
	 */
	public synchronized String take(){
		while(isEmpty){
			try{
				wait();
			}catch (InterruptedException e){
				System.out.println("oops..");
			}
		}
		isEmpty = true;
		notifyAll();
		return message;
	}
	
	/**
	 * Assign a message to the queue string
	 * @param message
	 */
	public synchronized void put(String message){
		while(!isEmpty){
			try{
				wait();
			}catch (InterruptedException e){
				System.out.println("oops..");
			}
		}
		this.message = message;
		isEmpty = false;
		notifyAll();
	}
}
