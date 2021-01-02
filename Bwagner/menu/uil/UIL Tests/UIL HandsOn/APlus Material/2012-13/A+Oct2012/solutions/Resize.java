import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Resize
{
	public static void main(String[] args) throws IOException
	{
		int i,a;
		double x0,y0,x1,y1;
		
		String s,s1;
		String[] t;	
		
		Scanner input = new Scanner(new File("resize.dat"));
		PrintWriter output = new PrintWriter(new File("resize.out"));			
		
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			t=s.split("\\s+");
			x0=Double.parseDouble(t[0]);
			y0=Double.parseDouble(t[2]);
			x1=Double.parseDouble(t[4]);
			y1=Double.parseDouble(t[6]);
			
			out.printf("%.2f by %.2f or %.2f by %.2f\n",x1,(x1*y0/x0),(x0*y1/y0),y1);
			output.printf("%.2f by %.2f or %.2f by %.2f",x1,(x1*y0/x0),(x0*y1/y0),y1);
			output.println();		
		}
	
	input.close();
	output.close();	
	}
}