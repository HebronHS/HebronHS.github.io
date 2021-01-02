import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr52
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr52.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	String []s = kb.nextLine().split(" ");   // array of words
      	for(int i = 0; i < s.length; i++) {
      		Set<Character> letters = new TreeSet<Character>(); // alphabetize word
      		for(int j = 0; j < s[i].length(); j++)
      			letters.add(s[i].charAt(j));
      		for(Character c : letters)			// enhanced for loop
      			out.print(c);
      		out.print(" ");
      	}
      	out.println();
      }	
   }
}

