import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr19
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr19.dat"));
      int times  = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
      	String s = kb.nextLine().trim();
      	int alpha=0, digit=0, other=0; 
      	for(int i = 0; i < s.length(); i++) {
      		char ch = s.charAt(i);
      		if(ch >= 'A' && ch <= 'Z')
      			alpha++;
      		else if(ch >= '0' && ch <= '9')
      			digit++;
      		else
      			other++;
      	}
      	out.printf("LETTERS:%3d DIGITS:%3d OTHER:%3d\n",alpha, digit,other);
      }	
   }
}

