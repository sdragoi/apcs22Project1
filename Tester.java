import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		System.out.print("Please specify either 5, 10, 50, or 100 million runs by inputting 5, 10, 50, or 100. ");
		
		int runs;
		Scanner input = new Scanner(System.in);
		if (input.hasNextInt()) {
			switch (input.nextInt()){
			case 5:	
			case 10:
			case 50:
			case 100:
				runs = input.nextInt();
			default:
				System.out.println("Please enter a valid input.");
			}
		}
		else {
			System.out.println("INVALID INPUT: Please enter an integer.");
		}
		

		int k = input.nextInt();
		System.out.println("Your input: " + k);
		

	}

}
