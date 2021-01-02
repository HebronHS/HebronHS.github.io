import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr62
{
	public static void main (String[] args) throws IOException
  	{
    	Scanner kb = new Scanner(new File("pr62.dat"));
    	String[] s = kb.nextLine().trim().split(" ");
    	int times = Integer.parseInt(s[0]);
    	for(int z = 1; z < 2*times; z+=2) {  			// start with s[1]
    	    int length = Integer.parseInt(s[z]);
    	    int width = Integer.parseInt(s[z+1]);
    	    
     	  	int minutes = (int)Math.round(length*width/90.);
      	  	out.printf("%d:%02d\n",minutes/60, minutes%60);		
		}
   	}
}

