import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr29
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr29.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
      	String s = kb.nextLine().trim();
      	String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
      	for(int i = 0; i < s.length()-1; i++) 
      		if(a.indexOf(s.substring(i,i+1)) >= 0) 
      			out.print(s.charAt(i));
      	out.println();
      }	
   }
}

