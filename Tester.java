import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		Scanner input;
		
		do {
			System.out.print("Please specify either 5, 10, 50, or 100 million runs by inputting 5, 10, 50, or 100. ");
			input = new Scanner(System.in);
		}
		while (!(input.nextInt() == 5 || input.nextInt() == 10 || input.nextInt() == 50 || input.nextInt() == 100));
		
	
		
		int runs = input.nextInt();
		
		int k = input.nextInt();
		System.out.println("Your input: " + k);
		

	}

}
