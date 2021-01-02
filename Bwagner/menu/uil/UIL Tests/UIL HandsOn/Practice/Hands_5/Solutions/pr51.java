import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr51
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr51.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	String s = kb.nextLine();
      	Set<Character> letters = new TreeSet<Character>(); 
      	for(int i = 0; i < s.length(); i++)
      		if(s.charAt(i) != ' ')		
      			letters.add(s.charAt(i));
      	for(Character c : letters)			// enhanced for loop
      		out.print(c);
      	out.println();
      }	
   }
}

