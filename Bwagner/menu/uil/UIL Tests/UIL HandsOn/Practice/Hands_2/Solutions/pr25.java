import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr25
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr25.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
      	StringBuffer s = new StringBuffer(kb.nextLine().trim());
      	int indexStart, indexEnd = 0;
      	indexStart = s.indexOf("/*");  
      	if(indexStart >= 0) {
      		indexEnd = s.indexOf("*/")+2;  
      		s.delete(indexStart,indexEnd);
      	}
      	out.println(s);
      }	
   }
}

