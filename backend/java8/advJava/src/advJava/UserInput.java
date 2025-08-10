package advJava;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInput {

	public static void main(String[] args) {
		System.out.println("Enter the number : ");
		try{
//			int num = System.in.read();
//			System.out.println("You entered : "+ (num-48));
			
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader rd = new BufferedReader(in);
			
			int num = Integer.parseInt(rd.readLine());
			System.out.println("You entered : " + num);
			
			
			
		}
		catch(Exception e) {
			System.out.println("Error occure");
		}
		
	}

}
