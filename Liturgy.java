// Stephanie Dragoi, Marton Sharpe
// 20220225
// Project #1- Probability Simulation- Liturgy Class

import java.util.ArrayList;
import java.util.Arrays;

public class Liturgy {
	
	public Hymn hymn1;
	public Hymn hymn2;
	public Hymn hymn3;

	private static Hymn[] hymnal = new Hymn[1131]; 
	
	{
		for (int i = 57; i < 905; i++) { // populate the hymnal array with Hymn objects
			hymnal[i - 57] = new Hymn(i);
		}
		for (int j = 2001; j < 2284; j++) {
			hymnal[j - 1153] = new Hymn(j); }
	}
	
		
	public Liturgy() {
		ArrayList<Hymn> hymnPool = new ArrayList<Hymn>(); // make ArrayList "hymnPool" for easier manipulation of available hymns
		
		for (int k = 0; k < 1131; k++) {
			hymnPool.add(hymnal[k]);
		}
		
		hymn1 = hymnPool.get((int)(Math.random() * (hymnPool.size() - 1)));
			if (hymn1.hymnNumber < 905)  
				hymnPool.remove(hymn1.hymnNumber - 57);
			else 
				hymnPool.remove(hymn1.hymnNumber - 1153);
		hymn2 = hymnPool.get((int)(Math.random() * (hymnPool.size() - 1)));
			if (hymn2.hymnNumber < 905)
					hymnPool.remove(hymn2.hymnNumber - 57);
			else if (hymn2.hymnNumber > 2000)
					hymnPool.remove((hymn2.hymnNumber - 1153));
		hymn3 = hymnPool.get((int)(Math.random() * (hymnPool.size() - 1)));
	}
	
	public Liturgy(Hymn hymn1, Hymn hymn2, Hymn hymn3) {
		this.hymn1 = hymn1;
		this.hymn2 = hymn2;
		this.hymn3 = hymn3;
	}
	
	public static double getProbability(Long targetDigits, Integer numberOfRuns, boolean printMatches) { // method that returns probability of targetDigits appearing in a given selection of hymns
		
		
		int matches = 0;
		if (printMatches)
			System.out.println("Matches:");
		
		for (int p = 0; p < numberOfRuns * 1000000; p++) 
			if (Liturgy.equals(targetDigits, new Liturgy(), printMatches)) { 
				matches ++;
			}
		
		if (printMatches)
			System.out.println(matches + " matches found.");
	
		double probability = (double) matches/((double)(numberOfRuns * 1000000));
		return probability;
		
	}
	
	private static String liturgyToString(Liturgy testLiturgy) {
		return (testLiturgy.hymn1.hymnNumber.toString() + "" + testLiturgy.hymn2.hymnNumber.toString() + testLiturgy.hymn3.hymnNumber.toString());
	}
	
	public static boolean equals(Long target, Liturgy liturgy, boolean printMatches) {
		
		String liturgyString = Liturgy.liturgyToString(liturgy);
		char liturgyArray[] = liturgyString.toCharArray();
		Arrays.sort(liturgyArray);
		String targetString = target.toString();
		char targetArray[] = targetString.toCharArray();
		Arrays.sort(targetArray);
		
		if (Arrays.equals(liturgyArray, targetArray)) {
			if (printMatches) {
				System.out.print("hymn 1: " + liturgy.hymn1.hymnNumber);
				System.out.print(", hymn 2: " + liturgy.hymn2.hymnNumber);
				System.out.println(", hymn 3: " + liturgy.hymn3.hymnNumber);
			}
			liturgyString = null;
			liturgyArray = null;
			liturgy = null;
			targetArray = null;
			target = null;
			targetString = null;
			return true;
		}
		else {
			liturgyString = null;
			liturgyArray = null;
			liturgy = null;
			targetArray = null;
			target = null;
			targetString = null;
			return false;
		}
	}
	
	public static double getSTDofMultipleRuns(Long targetDigits, int numOfRuns) {
		
		double[] probabilityValues = new double[10];
		
		for (int j = 0; j < 10 ; j++) 
			probabilityValues[j] = Liturgy.getProbability(targetDigits, numOfRuns, false);
		
			
		double sumOfProbs = 0;
		for (int j = 0; j < probabilityValues.length; j++)
			sumOfProbs += probabilityValues[j];
		
		
		double meanOfProbs = sumOfProbs/probabilityValues.length;
			
		double sumForStD = 0;
		for (int i = 0; i < probabilityValues.length; i++) 
			sumForStD += (Math.pow((probabilityValues[i] - meanOfProbs), 2));
		
		
		double standardDeviation = Math.sqrt(sumForStD/probabilityValues.length);
		
		return standardDeviation;		
	}
	
	public static double getMADofMultipleRuns(Long targetDigits, int numOfRuns) {
		double[] probabilityValues = new double[10];
		
		for (int j = 0; j < 10 ; j++) 
			probabilityValues[j] = Liturgy.getProbability(targetDigits, numOfRuns, false);
		
		double sumOfProbs = 0;
		for (int j = 0; j < probabilityValues.length; j++)
			sumOfProbs += probabilityValues[j];
		
		
		double meanOfProbs = sumOfProbs/probabilityValues.length;
		
		double sumForMAD = 0;
		for (int i = 0; i < probabilityValues.length; i++) 
			sumForMAD += (Math.abs(probabilityValues[i] - meanOfProbs));
		
		return (sumForMAD/(double)probabilityValues.length); 
	}
	
}

