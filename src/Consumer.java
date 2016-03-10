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
	public Consumer(Box box){
		this.box = box;
	}
	
	/**
	 * 
	 */
	public void run(){
		for(String message = box.take(); !message.equals("DONE"); message = box.take()){
			System.out.println(message);
		}
	}
}
