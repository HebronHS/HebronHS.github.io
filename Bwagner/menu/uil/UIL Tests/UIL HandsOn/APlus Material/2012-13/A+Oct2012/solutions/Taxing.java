import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Taxing
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d;
		double x,total;
		
		String s,s1;
		String[] t;
	
		
		Scanner input = new Scanner(new File("taxing.dat"));
		PrintWriter output = new PrintWriter(new File("taxing.out"));
			
		
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			x=Double.parseDouble(s);
			total=1.0825*x;			
				
			out.printf("$%.2f\n",total);
			output.printf("$%.2f",total);output.println();				
		
		}
	
	input.close();
	output.close();	
	}
}