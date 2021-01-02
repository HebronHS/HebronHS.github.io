import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Speed
{
	public static void main(String[] args) throws IOException
	{
		int i,a;
		double x,total;
		
		String s,s1;
		String[] t;	
		
		Scanner input = new Scanner(new File("speed.dat"));
		PrintWriter output = new PrintWriter(new File("speed.out"));
				
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			x=Double.parseDouble(s);
			total=x/5.0;			
				
			out.printf("%.1f\n",total);
			output.printf("%.1f",total);output.println();				
		
		}
	
	input.close();
	output.close();	
	}
}