import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class MalFunction
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,e;
		double c1,c2,c3,x,fx;
		
		String s,s1;
		String[] t;
			
		Scanner input = new Scanner(new File("malfunction.dat"));
		PrintWriter output = new PrintWriter(new File("malfunction.out"));	
		
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
		
			s=input.nextLine().trim();
			t=s.split("\\s+");
			c1=Double.parseDouble(t[0]);
			c2=Double.parseDouble(t[1]);
			c3=Double.parseDouble(t[2]);
			x=Double.parseDouble(t[3]);
			
			fx=c1*x*x + c2*x + c3;
						
			out.printf("%.3f \n", fx);
			output.printf("%.3f", fx);output.println();				
		}
	
	input.close();
	output.close();	
	}

}