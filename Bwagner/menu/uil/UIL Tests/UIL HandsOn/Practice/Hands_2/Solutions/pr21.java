import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr21
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr21.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	String s = kb.nextLine(); 
      	char ch = s.charAt(0);
      	int count = 1;
      	for(int i = 1; i < s.length(); i++)
      		if(s.charAt(i) == ch)			// looks at one character
      			count++;
      	out.println(ch + ": " + count);
      }	
   }
}

