import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr41
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr41.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	String s = kb.nextLine();	
      	for(int i = 0; i < s.length(); i++) {
      		for(int j = 0; j < i+1; j++)  
       			out.print(s.charAt(j));
       		out.println();
       	}
       	out.println();
      }	
   }
}

