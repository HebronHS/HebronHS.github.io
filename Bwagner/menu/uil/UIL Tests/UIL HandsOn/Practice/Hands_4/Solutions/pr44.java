import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr44
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr44.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
        String s = kb.nextLine().trim();    
        StringBuffer r = new StringBuffer(s).reverse();		
	   	String blanks = "                                                               ";
       	// print word
       	out.println(s);	
       	// print diagonals to middle		
		int rows = s.length();
		int numSpaces = rows-4; 
       	for(int i = 1; i < rows/2; i++) {	
      		out.print(blanks.substring(0,i));  
      		out.print(s.charAt(i));
      		out.print(blanks.substring(0,numSpaces)); 
      		numSpaces-=2;  					 // decrease for next iteration
      		out.println(r.charAt(i)); 
      	}
      	// print middle character
		out.println(blanks.substring(0,rows/2) + s.charAt(rows/2 ));
      	
      	// print bottom diagonal
		numSpaces = 1;
		rows = s.length();
    	for(int j = 1; j < rows/2; j++) {
			out.print(blanks.substring(0, rows/2-j)); 
   			out.print(r.charAt(rows/2+j));      	
   			out.print(blanks.substring(0,numSpaces));
   			numSpaces+=2;
   			out.println(s.charAt(rows/2+j));      
      	}
     	out.println(s);	
     
       	out.println();
      }	
   }
}

