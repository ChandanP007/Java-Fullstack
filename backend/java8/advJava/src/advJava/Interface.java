package advJava;

public class Interface {
	@FunctionalInterface
	interface A{
		void run();
	}
	
	@FunctionalInterface
	interface B{
		void walk(String msg);
	}
	
	@FunctionalInterface
	interface Sum{
		int sum(int a, int b);
	}

	public static void main(String[] args) {
		A obj = ()-> System.out.println("Running");
		
		B obj2 = msg -> System.out.println(msg);
		
		
		obj.run();
		obj2.walk("Walking");
		
		//Lambda expression with return 
		Sum c = (i,j)-> i+j;
		
		int result = c.sum(2, 5);
		System.out.println(result);
	}
}

