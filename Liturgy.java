import java.util.ArrayList;
import java.util.Random;

public class Liturgy {
	
	public Hymn hymn1;
	public Hymn hymn2;
	public Hymn hymn3;

	public static Hymn[] hymnal = new Hymn[1131];
	
	
	
	public static void main(String[] args) { // ok to have main before constructor?
		
		for (int i = 57; i < 905; i++) { // populate the hymnal array with Hymn objects
			hymnal[i - 57] = new Hymn(i);
		}
		for (int j = 2001; j < 2284; j++) {
			hymnal[j - 1153] = new Hymn(j);
		}
	}
	
	public Liturgy() {
		ArrayList<Hymn> hymnPool = new ArrayList<Hymn>(); // make ArrayList "hymnPool" for easier manipulation of available hymns
		
		for (int k = 0; k < 1132; k++) {
			hymnPool.add(hymnal[k]);
		}
		
		hymn1 = hymnal[(int)Math.random() * 1131];
			if (hymn1.hymnNumber < 905) // ok to have non-automatic indents here for readability?
				hymnPool.remove(hymn1.hymnNumber - 57);
			else
				hymnPool.remove(hymn1.hymnNumber - 1153);
		hymn2 = hymnal[(int)Math.random() * 1131];
			if (hymn2.hymnNumber < 905)
				hymnPool.remove(hymn2.hymnNumber - 57);
			else
				hymnPool.remove(hymn2.hymnNumber - 1153);
		hymn3 = hymnal[(int)Math.random() * 1131];
			if (hymn3.hymnNumber < 905)
				hymnPool.remove(hymn3.hymnNumber - 57);
			else
				hymnPool.remove(hymn3.hymnNumber - 1153);
		
	}
	
	public static double getProbability(int targetDigits) { // method that returns probability of targetDigits appearing in a given selection of hymns
		for (int p = 0; p < 100000000; p++) {
			
		}
		
	}
}

