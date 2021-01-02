import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr65
{
	public static void main (String[] args) throws IOException
  	{
    	Scanner kb = new Scanner(new File("pr65.dat"));
    	int times = Integer.parseInt(kb.nextLine().trim());
    	int totalMinutes=0;
    	for(int z = 0; z < times; z++)  { 
    		String[] s =  kb.nextLine().trim().split(" ");
    	    double principal = Double.parseDouble(s[0]);		
    	    double rate = (Double.parseDouble(s[1]))/1200;
    	    int months = Integer.parseInt(s[2]);
    	    out.printf("%3d  $%10.2f\n", 0, principal);
    	    for(int i = 1; i <= months; i++) {
    	    	principal *= (1 + rate);
    	    	out.printf("%3d  $%10.2f\n", i, principal);
    	    }
    	    out.println();
		}
		
   	}
}

