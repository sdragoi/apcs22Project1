import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		int runs;
		do {
		    System.out.println("Please specify either 5, 10, 50, or 100 million runs by inputting 5, 10, 50, or 100. ");
		    while (!input.hasNextInt()) {
		        System.out.println("Not an integer. ");
		        input.next(); 
		    }
		    runs = input.nextInt();
		    if (runs == 5 || runs == 10 || runs == 50 || runs == 100)
		    	break;
		} while (runs != 5 || runs != 10 || runs != 50 || runs != 100); 
		
		Scanner target = new Scanner(System.in);
		Integer targetPattern;
		do {
			System.out.println("Please provide a target digit pattern between 6 and 12 digits. ");
			while (!target.hasNextInt()) {
				System.out.println("Your target pattern should only contain the digits 0-9. ");
				target.next();
			}
			targetPattern = target.nextInt();
		} while (targetPattern.toString().length() > 12 || targetPattern.toString().length() < 6);
		
			
		System.out.println("Probability of a given Liturgy containing three hymns with the same digits as your pattern: " + Liturgy.getProbability(targetPattern, runs));
		
	}


}
