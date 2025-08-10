package advJava;

class Counter{
	int count; 
	public synchronized void increment() {
		count++;
	}
}

class N implements Runnable{
	public void run() {
		for(int i=1; i<20; i++) {
			System.out.println("hi");
		}
		
		try {
			Thread.sleep(100);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class M implements Runnable{
	public void run() {
		for(int i=1; i<20; i++) {
			System.out.println("hello");
		}
		
		try {
			Thread.sleep(100);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Threading {

	public static void main(String[] args) {
		
//		Runnable obj = new N();
//		Runnable obj2 = new M();
		
		
//		Runnable obj = () -> {
//			for(int i=1; i<20; i++) {
//				System.out.println("HI");
//				try {Thread.sleep(100);} catch(InterruptedException e) {e.printStackTrace();}
//			}
//		};
//		
//		Runnable obj2 = () -> {
//			for(int i=1; i<20; i++) {
//				System.out.println("Hello");
//				try {Thread.sleep(100);} catch(InterruptedException e) {e.printStackTrace();}
//			}
//		};
//		
//		
//		Thread t1 = new Thread(obj);
//		Thread t2 = new Thread(obj2);
		
//		t1.start();
//		t2.start();
		
		
		//Synchronized
		Counter c = new Counter();
		
		Runnable obj3 = ()-> {
			for(int i=1; i<=10000; i++) {
				c.increment();
			}
		};
		
		Runnable obj4 = ()-> {
			for(int i=1; i<=10000; i++) {
				c.increment();
			}
		};
		
		Thread t3 = new Thread(obj3);
		Thread t4 = new Thread(obj4);
		
		t3.start();
		t4.start();
		
		try {
			t3.join();
			t4.join();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("FINAL : " + c.count);

	}
	
	
}



// Thread States : Runnable -> Running -> Waiting -> Runnable -> Running -> Stop