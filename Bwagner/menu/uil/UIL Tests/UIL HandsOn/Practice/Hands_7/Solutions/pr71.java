import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr71
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr71.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++)  {  
          String s = kb.nextLine().trim();
          // strip out all not letters
          String p = "";
      	  for(int i = 0; i < s.length(); i++) {
      	  	  char ch = s.charAt(i);
	          if(ch >= 'A' && ch <= 'Z')
			  	  p += ch;
		  }	  	   		
		  boolean b = true;
		  int i = 0;  
		  while(b && i<p.length()/2) {
		  	  if(p.charAt(i) != p.charAt(p.length()-i-1))
		  	  	  b = false;		// found non-matching letters
		  	  i++;
		  }
		  if(b)
		  	out.println("PALINDROME");
		  else
		  	out.println("NOT PALINDROME");  
	   }
   }
}

