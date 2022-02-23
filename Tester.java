import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		System.out.print("");
		
		Scanner input = new Scanner(System.in);
		int runs;
		do {
		    System.out.println("Please specify either 5, 10, 50, or 100 million runs by inputting 5, 10, 50, or 100. ");
		    while (!input.hasNextInt()) {
		        System.out.println("Not an integer.");
		        input.next(); // this is important!
		    }
		    runs = input.nextInt();
		} while (runs <= 0);
		
		
		
	}


}
