import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr27
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr27.dat"));
      int times = Integer.parseInt(kb.nextLine());
      String vowels = "AEIOU";
      for(int z = 0; z < times; z++) {
      	String []s = kb.nextLine().split(" ");				
      	for(int i = 0; i < s.length; i++)  
       		if(vowels.indexOf(s[i].charAt(0)) < 0)      // not a vowel
      			out.print(s[i].substring(1) + s[i].substring(0,1) + "AY ");
			else										// is a vowel
				out.print(s[i] + "YAY ");
      	out.println();
      }	
   }
}

