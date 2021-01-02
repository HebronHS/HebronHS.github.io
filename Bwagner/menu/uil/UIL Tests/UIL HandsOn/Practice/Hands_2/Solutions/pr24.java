import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr24
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr24.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
      	String s = kb.nextLine().trim();
      	int len = s.length();
      	int start = 1;
      	char extraLetter = ' ';
      	if(len%2 == 1) {
      		extraLetter = s.charAt(0);
      		start++;
      	}
      	for(int i = start; i < len; i+=2) {
      		out.print(s.charAt(i));
      		out.print(s.charAt(i-1)); 
		}
      	out.println(extraLetter);
      }	
   }
}

