package advJava;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

class Balak{
	private String name;
	private int age;
	public Balak() {
		
	}
	public Balak(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}

public class Optionals {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Navin","Laxmi","John");
		
		String name = names.stream()
				.filter(str -> str.contains("x"))
				.findFirst()
				.orElse("Not found");
		
		
		//Method reference
		List<String> uNames = names.stream()
				.map(String::toUpperCase)
				.toList();
		
		
		
		uNames.forEach(System.out::println);
		
		
		List<Balak> students = new ArrayList<>();
		
		
		//Constructor Reference
		students = names.stream()
				.map(Balak::new)
				.toList();
		
		System.out.println(students);
	}
}
