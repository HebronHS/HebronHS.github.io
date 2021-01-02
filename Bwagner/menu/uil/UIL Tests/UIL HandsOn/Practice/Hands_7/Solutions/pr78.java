import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr78 {
	private static char [][]m;
	public static void main (String[] args) throws IOException 	{
		Scanner kb = new Scanner(new File("pr78.dat"));
		String row = kb.nextLine().trim();
		int len = row.length();
		m = new char[len][len];
		m[0] = row.toCharArray();
		for(int z = 1; z < len; z++)  {   // read rows into matrix
			row = kb.nextLine().trim();
			m[z] = row.toCharArray();
		}
		
		while(kb.hasNext()) 	{
			String word = kb.nextLine().trim();
			
			boolean found = false;
			for(int r = 0; !found && r < len; r++)	{	// search matrix for first letter
				for(int c = 0; !found && c < len; c++) {
					// if first letter of word is at spot, check to see if word is in matrix
					if(word.charAt(0)==m[r][c]) {
						found = checkRight(word, r, c, len) || 			
					    		checkLeft(word, r, c, len) ||
							  	checkUp(word, r, c, len) ||
								checkDown(word, r, c, len) ||
								checkDiagUpRight(word, r, c, len) || 
					    		checkDiagUpLeft(word, r, c, len) ||
							  	checkDiagDownLeft(word, r, c, len) ||
								checkDiagDownRight(word, r, c, len);
					}
				}
			}
			if(found)
				out.println(word + " APPEARS IN THE MATRIX");
			else
				out.println(word + " DOES NOT APPEAR IN THE MATRIX");
	   	}	
	}
	public static boolean checkRight(String w, int r, int c, int len) {
		int i = 0;
		while(i < w.length()) {
			if(c+i<0 || c+i>=len)		// spot to check is out of matrix - return false
				return false;
			if(w.charAt(i)!= m[r][c+i]) // char at spot doesn't match word - return false
				return false;
			i++;						// check next spot
		}					
		return true;					// all letters matched
	}
	public static boolean checkLeft(String w, int r, int c, int len) {
		int i = 0;
		while(i < w.length()) {
			if(c-i<0 || c-i>=len) 
				return false;
			if(w.charAt(i)!= m[r][c-i]) 
				return false;
			i++;
		}					
		return true;
	}
	public static boolean checkUp(String w, int r, int c, int len) {
		int i = 0;
		while(i < w.length()) {
			if(r-i<0 || r-i>=len)
				return false;
			if(w.charAt(i)!= m[r-i][c]) 
				return false;
			i++;
		}					
		return true;
	}
	public static boolean checkDown(String w, int r, int c, int len) {
		int i = 0;
		while(i < w.length()) {
			if(r+i<0 || r+i>=len)
				return false;
			if(w.charAt(i)!= m[r+i][c]) 
				return false;
			i++;
		}					
		return true;
	}
	public static boolean checkDiagUpRight(String w, int r, int c, int len) {
		int i = 0;
		while(i < w.length()) {
			if(r-i<0 || r-i>=len || c+i<0 || c+i>=len)
				return false;
			if(w.charAt(i)!= m[r-i][c+i]) 
				return false;
			i++;
		}						
		return true;
	}	
	public static boolean checkDiagUpLeft(String w, int r, int c, int len) {
		int i = 0;
		while(i < w.length()) {
			if(r-i<0 || r-i>=len || c-i<0 | c-i>=len) 
				return false;
			if(w.charAt(i)!= m[r-i][c-i]) 
				return false;
			i++;
		}					
		return true;
	}	
	public static boolean checkDiagDownLeft(String w, int r, int c, int len) {
		int i = 0;
		while(i < w.length()) {
			if(r+i<0 || r+i>=len || c-i<0 || c-i>=len)
				return false;
			if(w.charAt(i)!= m[r+i][c-i]) 
				return false;
			i++;
		}					
		return true;
	}
	public static boolean checkDiagDownRight(String w, int r, int c, int len) {
		int i = 0;
		while(i < w.length()) {
			if(r+i<0 || r+i>=len || c+i<0 || c+i>=len) 
				return false;
			if(w.charAt(i)!= m[r+i][c+i]) 
				return false;
			i++;
		}						
		return true;
	}	
}

