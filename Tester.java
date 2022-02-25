import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int runs;
		do {
		    System.out.println("Please specify either 1, 5, or 10 million runs by inputting 1, 5, or 10. ");
		    while (!input.hasNextInt()) {
		        System.out.println("Not an integer. ");
		        input.next(); 
		    }
		    runs = input.nextInt();
		    if (runs == 1 || runs == 5 || runs == 10)
		    	break;
		} while (runs != 1 || runs != 5 || runs != 10); 
		
		Scanner target = new Scanner(System.in);
		Long targetPattern;
		do {
			System.out.println("Please provide a target digit pattern between 6 and 12 digits. ");
			while (!target.hasNextLong()) {
				System.out.println("Your target pattern should only contain the digits 0-9. ");
				target.next();
			}
			targetPattern = target.nextLong();
		} while (targetPattern.toString().length() > 12 || targetPattern.toString().length() < 6);
		
			
		System.out.println("Probability of a given Liturgy containing three hymns with the same digits as your pattern: " + Liturgy.getProbability(targetPattern, runs, true));
		System.out.println("Mean absolute deviation for the simulation with the given target digit pattern and number of runs: " + Liturgy.getMADofMultipleRuns(targetPattern, runs));
		
	}


}
