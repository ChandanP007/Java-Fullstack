package advJava;

enum Status{
	Running, Failed, Pending, Success;
}
enum Laptop{
	Macbook(2000), XPS(2000), Surface, ThinkPad;
	
	private int price;
	
	private Laptop() {
		
	}
	
	private Laptop(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}

public class Enum {
	public static void main(String... a) {
		int i = 5;
		Status s = Status.Failed;
		System.out.println(s);
		System.out.println(s.ordinal());
		
		Status[] ss = Status.values();
//		for(Status x : ss) {
//			System.out.println(x);
//		}
		
		
		switch(s) {
		case Running : 
			System.out.println("Running");
			break;
		case Failed : 
			System.out.println("Failed");
			break; 
		}
		
//		Laptop lap = Laptop.Macbook;
//		System.out.println(lap +  " " + lap.getPrice());
//		
		for(Laptop lap : Laptop.values()) {
			System.out.println(lap + " : " + lap.getPrice());
		}
	}
}
