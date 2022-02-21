import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int runs;
		System.out.print("Please specify either 5, 10, 50, or 100 million runs by inputting 5, 10, 50, or 100. ");
		if (!(input.nextInt() == 5 || input.nextInt() == 10 || input.nextInt() == 50 || input.nextInt() == 100)) {
			System.out.println("Not within the specified parameters.");
		}

		
		runs = input.nextInt();
		
		int k = input.nextInt();
		System.out.println("Your input: " + k);
		

	}

}
