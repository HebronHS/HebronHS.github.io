import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr45
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr45.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
        String s = kb.nextLine().trim(); 
           
        StringBuffer r = new StringBuffer(s).reverse();	
	   	String blanks = "                                 ";
       			
		int rows = s.length();
		int numSpaces = s.length()-2; 
       	// print word
       	out.println(s);			
		// print sides
       	for(int i = 1; i < rows-1; i++) {	
      		out.print(s.charAt(i));
      		out.print(blanks.substring(0,numSpaces)); 
       		out.println(r.charAt(i)); 
      	}
      	// print reversed word
       	out.println(r);  

       	out.println();
      }	
   }
}

