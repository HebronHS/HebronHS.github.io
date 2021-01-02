import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Integral
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,e;
		double x1,x2,dx,fx,integral,y;
		
		String s,s1;
		String[] t;
			
		Scanner input = new Scanner(new File("integral.dat"));
		PrintWriter output = new PrintWriter(new File("integral.out"));	
		
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
		
			s=input.nextLine().trim();
			t=s.split("\\s+");
			x1=Double.parseDouble(t[0]);
			x2=Double.parseDouble(t[1]);
			dx=Double.parseDouble(t[2]);
			integral=0.0;
				
			for(y=x1;y<x2;y+=dx)
			{
				fx=3*y*y + 2*y + 1;
				integral+=fx*dx;
				//out.println("      "+y);
			}
			//out.println(y);
			out.printf("%.6f \n", integral);
			output.printf("%.6f", integral);output.println();	
		
			
			
		}	
	
	
	input.close();
	output.close();	
	}

}