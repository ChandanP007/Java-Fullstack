package advJava;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

class Student{
	int age;
	String name;
	
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
	
}

public class Collect {

	public static void main(String[] args) {
		Map<String, Integer> students = new HashMap<>();
		students.put("Rahul", 234);
		students.put("Navin", 234);
		students.put("Mohit", 234);
		students.put("Sumit", 234);
		
		Comparator<Integer> com = new Comparator<Integer>() {
			public int compare(Integer i, Integer j) {
				if(i%10 > j%10) {
					return 1;
				}else {
					return -1;
				}
			}
		};
		
		List<Integer> nums = new ArrayList<>();
		nums.add(43);
		nums.add(32);
		nums.add(71);
		nums.add(26);
		
		Collections.sort(nums,com);
		
		ArrayList<String> names = new ArrayList<>();
		names.add("Mohit");
		names.add("Chandan");
		names.add("Aman");
		names.add("Kid");
		
		Comparator<String> comNames = (String name1, String name2) -> name1.length() > name2.length() ? 1 : -1;
		
		Collections.sort(names,comNames);
		
		List<Student> studs = new ArrayList();
		studs.add(new Student(21,"Rohit"));
		studs.add(new Student(22,"Rohan"));
		studs.add(new Student(23,"Rahul"));
		
		Comparator<Student> com2 = (Student s1, Student s2) -> s1.age > s2.age ? 1 : -1;
		
		
		Collections.sort(studs,com2);
		
//		System.out.println(studs);
//		System.out.println(nums);
		System.out.println("Names : " + names);
		
		
	}

}
