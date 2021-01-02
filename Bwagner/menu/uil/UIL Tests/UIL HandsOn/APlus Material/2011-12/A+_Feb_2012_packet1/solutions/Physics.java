import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Physics
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d;
		double theta, dx, g=9.81, v;
		String s,s1,s2;
		String[] t;
		
		Scanner input = new Scanner(new File("physics.dat"));
		PrintWriter output = new PrintWriter(new File("physics.out"));
		s=input.nextLine().trim();
		a=Integer.parseInt(s);	
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			t=s.split("\\s+");
			v=Double.parseDouble(t[0]);
			theta=2.0*Math.toRadians(Double.parseDouble(t[1]));
			dx=v*v*Math.sin(theta)/g;
			out.printf("x = %.3f m \n",dx);
			output.printf("x = %.3f m",dx);output.println();			
		}
		
				
	
	input.close();
	output.close();	
	}
}