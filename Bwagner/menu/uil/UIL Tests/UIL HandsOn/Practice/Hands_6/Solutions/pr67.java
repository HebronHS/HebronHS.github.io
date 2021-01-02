import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr67
{
	public static void main (String[] args) throws IOException
  	{
    	Scanner kb = new Scanner(new File("pr67.dat"));
    	int times = Integer.parseInt(kb.nextLine().trim());
    	for(int z = 0; z < times; z++)  { 
     		String[] s =  kb.nextLine().trim().split(" ");
    	    int length = Integer.parseInt(s[0]);		
    	    int width = Integer.parseInt(s[1]);
			int gates = Integer.parseInt(s[2]);
			int fencePanels = (int) Math.ceil((length * width  - 4 * gates)/ 6.);
			double cost = 19.95 * fencePanels + 29.95 * gates;
    	    out.printf("$%.2f\n", cost);
		}
		
   	}
}

