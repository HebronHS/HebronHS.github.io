import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr64
{
	public static void main (String[] args) throws IOException
  	{
    	Scanner kb = new Scanner(new File("pr64.dat"));
    	int times = Integer.parseInt(kb.nextLine().trim());
      	
    	for(int z = 0; z < times; z++)  {  
    	    int inches = Integer.parseInt(kb.nextLine().trim());
     	  	int rolls = (int)Math.ceil(inches/1200.);
     	  	double cost = 0;
      	  	if(rolls < 6)
      	  		cost = rolls * 4.95;
      	  	else if(rolls < 12) 
				cost = rolls * 4.65;
      	  	else if(rolls < 24) 
      	  		cost = rolls * 4.15;
      	  	else
      	  		cost = rolls * 4.00;
      	  	out.printf("$%.2f FOR %d ROLLS\n",cost,rolls);		
		}
   	}
}

