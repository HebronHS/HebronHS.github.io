import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Skippy
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c;
		String s;
				
		Scanner input = new Scanner(new File("skippy.dat"));
		PrintWriter output = new PrintWriter(new File("skippy.out"));
		s=input.nextLine().trim();
		a=Integer.parseInt(s);	
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			b=Integer.parseInt(s);
			for(c=1;c<=12;c++)
			{
				out.print(c*b+" ");
				output.print(c*b+" ");
				
			}
			out.println();
			output.println();		
						
		}
		
				
	
	input.close();
	output.close();	
	}
}