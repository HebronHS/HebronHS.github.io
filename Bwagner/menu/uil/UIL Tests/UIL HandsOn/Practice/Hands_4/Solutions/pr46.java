import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr46
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr46.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
        String s = kb.nextLine().trim();   
        StringBuffer r = new StringBuffer(s).reverse();	
	   	String blanks = "                                 ";
       			
		int rows = s.length();
		int numSpaces = 1; 
       	// print first character
       	out.print(blanks.substring(0, rows-1));
       	out.println(s.charAt(0));			
		// print diagonals to middle
       	for(int i = 1; i < rows; i++) {	
      		out.print(blanks.substring(0,rows-1-i));  
      		out.print(s.charAt(i));
      		out.print(blanks.substring(0,numSpaces)); 
      		numSpaces+=2;  					 // decrease for next iteration
      		out.println(s.charAt(i)); 
      	}
      	
      	// print bottom diagonal - uses r, not s
		numSpaces = 2*rows - 5;
    	for(int j = 1; j < rows-1; j++) {
			out.print(blanks.substring(0, j)); 
   			out.print(r.charAt(j));      	
   			out.print(blanks.substring(0,numSpaces));
   			numSpaces-=2;
   			out.println(r.charAt(j));      
      	}
      	// print last character
       	out.print(blanks.substring(0, rows-1));
       	out.println(s.charAt(0));  
       	    	
       	out.println();
      }	
   }
}

