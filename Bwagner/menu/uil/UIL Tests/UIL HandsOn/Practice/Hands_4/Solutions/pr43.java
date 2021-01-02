import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr43
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr43.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
        String s = kb.nextLine(); 
        StringBuffer r = new StringBuffer(s).reverse();	   	
      	int rows = s.length();
      	String blanks = "                                ";
      	int numSpaces = rows-1;
      		out.print(blanks.substring(0,numSpaces--));  // decrease for next iteration
      		out.println(s.charAt(0));      	
       	for(int i = 1; i < rows - 1; i++) {	
      		out.print(blanks.substring(0,numSpaces--));  // decrease for next iteration
      		out.print(s.charAt(i));
      		out.print(blanks.substring(0,2*i-1));
      		out.println(s.charAt(i));
      	}
      	out.print(r);  // print word backwards
       			
       	out.println(s.substring(1)); // omit first letter

       	out.println();
      }	
   }
}

