package advJava;

public class Main {

	public static void main(String[] args) {
		
		
		//Anonymous Inner Class
		B obj = new B() {
			public void show() {
				System.out.println("In New Show");
			}
		};
		
		obj.show();
		
		
		//Abstract-anonymous class
		C obj1 = new C() {
			public void show() {
				System.out.println("Hello world");
			}
			public void config() {
				System.out.println("Config");
			}
		};
		
		obj1.show();

	}

}

class B{
	public void show() {
		System.out.println("In B Show");
	}
}

abstract class C{
	abstract void show();
	abstract void config();
}

interface D{
	void show();
	void config();
}