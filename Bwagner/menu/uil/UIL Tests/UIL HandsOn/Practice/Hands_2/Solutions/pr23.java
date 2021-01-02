import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr23
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr23.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	String s = kb.nextLine();
      	String temp = ""; 
      	for(int i = 0; i < s.length(); i++)
      		if(s.charAt(i) != ' ' && temp.indexOf(s.charAt(i)) < 0 )		
      			temp += s.charAt(i);
      	out.println(temp);
      }	
   }
}

