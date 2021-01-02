import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr55
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr55.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++)  {
	      ArrayList<Integer> a = new ArrayList<Integer>();
	      ArrayList<Integer> b = new ArrayList<Integer>(); 
	      String[] s = kb.nextLine().trim().split(" ");	
	      for(int i = 0; i < s.length-1; i+=2) {
	      	 a.add(Integer.parseInt(s[i]));
	      	 b.add(Integer.parseInt(s[i+1]));
	      }
	      if(s.length %2 ==1)
	      	 a.add(Integer.parseInt(s[s.length-1]));  // add last number if necessary
	      Collections.sort(a);				 // this will alphabetize the integers
	      Collections.sort(b);
	      for(Integer i : a) 
	      	  out.print(i + " "); 
	      out.print("^ ");
	      for(int i = b.size()-1; i >= 0; i--)	  
	      	  out.print(b.get(i) + " ");   
	      out.println();
	   }
	}
}

