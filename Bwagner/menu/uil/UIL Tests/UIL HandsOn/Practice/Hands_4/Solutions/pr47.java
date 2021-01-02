import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr47
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr47.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
        String s = kb.nextLine().trim(); 
      	int rows = s.length();
      	String blanks = "                                ";
		int numLetters = s.length();
      	// length of s is odd ==> first row has s.length() letters
		if(numLetters % 2 == 1) {
			// top half		
	       	for(int i = 0; i < rows/2+1; i++) {	
	      		out.print(blanks.substring(0,i));  // decrease for next iteration
	      		for(int j=0; j<numLetters; j++)
	      			out.print(s.charAt(i));
	      		numLetters-=2;
	      		out.println();
	      	}
			// bottom half 
			int nextChar = rows/2+1;   		// position of char to be printed
		    numLetters += 4;
		    int numSpaces = rows/2-1;					// number of letters to be printed
		    for(int i = rows/2; i > 0 ; i--) {	
		    	out.print(blanks.substring(0,numSpaces));  // decrease for next iteration
		    	for(int j=0; j<numLetters; j++)
		    		out.print(s.charAt(nextChar));  // increment letter
		    	numLetters += 2;
		    	nextChar++;
		    	numSpaces--;
		    	out.println();
		    }
		    out.println();	
	    }
       	else {// length of s is even ==> first row has s.length()-1 letters
			// top half	
			numLetters--;	
	       	for(int i = 0; i < rows/2; i++) {	
	      		out.print(blanks.substring(0,i));  // decrease for next iteration
	      		for(int j=0; j<numLetters; j++)
	      			out.print(s.charAt(i));
	      		numLetters-=2;
	      		out.println();
	      	}
			// bottom half 
			int nextChar = rows/2;   		// position of char to be printed
		    numLetters = 1;
		    int numSpaces = rows/2-1;					// number of letters to be printed
		    for(int i = rows/2; i > 0 ; i--) {	
		    	out.print(blanks.substring(0,numSpaces));  // decrease for next iteration
		    	for(int j=0; j<numLetters; j++)
		    		out.print(s.charAt(nextChar));  // increment letter
		    	numLetters += 2;
		    	nextChar++;
		    	numSpaces--;
		    	out.println();
		    }	
	    }
       	out.println();
      }	
   }
}

