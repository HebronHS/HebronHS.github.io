import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr69
{
	public static void main (String[] args) throws IOException
  	{
    	Scanner kb = new Scanner(new File("pr69.dat"));
    	double m=0, p=0, f=0, d=0, o=0;   // set all type totals to 0
    	double totalBill = 0;
		while(kb.hasNext()) {
    		String[] s =  kb.nextLine().trim().split(" ");
    	    char type = s[0].charAt(0);		
    	    double cost = Double.parseDouble(s[1]);
    	    switch(type) {
    	    	case 'M': m+=cost; break;
    	    	case 'P': p+=cost; break;
    	    	case 'F': f+=cost; break;
    	    	case 'D': d+=cost; break;
    	    	case 'O': o+=cost; break;
    	 	}
    	    totalBill += cost;
		}
		out.printf("Total bill: %.2f\n", totalBill);
		out.printf("%-10s$%7.2f%7.1f", "Meat:", m, m/totalBill*100); out.println("%");
		out.printf("%-10s$%7.2f%7.1f", "Produce:", p, p/totalBill*100); out.println("%");
		out.printf("%-10s$%7.2f%7.1f", "Food:", f, f/totalBill*100); out.println("%");
		out.printf("%-10s$%7.2f%7.1f", "Drugs:", d, d/totalBill*100); out.println("%");
		out.printf("%-10s$%7.2f%7.1f", "Other:", o, o/totalBill*100); out.println("%");
   	}
}

