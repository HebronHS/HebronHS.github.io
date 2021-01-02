import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr54
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr54.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      ArrayList<String> a = new ArrayList<String>();
      for(int z = 0; z < times; z++)       	
      	  a.add(kb.nextLine().trim());	
      Collections.sort(a);		// this will alphabetize strings
      String teacher = "";
      for(String i : a) {
      	  String [] temp = i.split(" "); 
      	  if(!temp[0].equals(teacher)) {  // print, if new teacher
      		  teacher = temp[0];
      		  out.println("\n" + teacher); 
      	  }
      	  out.println("   " + temp[1]);   // print student
      }	
   }
}

