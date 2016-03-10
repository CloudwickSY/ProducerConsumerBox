/**
 * 
 * @author Stanislav
 *
 */
public class Main {
	public static void main(String[] args) {
		Box b = new Box();
		Thread p = new Thread(new Producer(b));
		Thread c = new Thread(new Consumer(b));
		p.start();
		c.start();
		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
