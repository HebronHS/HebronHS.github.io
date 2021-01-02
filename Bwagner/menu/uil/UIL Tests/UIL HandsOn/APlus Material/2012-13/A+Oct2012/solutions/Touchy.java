import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Touchy
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d;
		
		String s,s1;
		String[] t;
	
		
		Scanner input = new Scanner(new File("touchy.dat"));
		PrintWriter output = new PrintWriter(new File("touchy.out"));
			
		
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			t=s.split("\\s+");
			
			b=Integer.parseInt(t[0]);	
			c=Integer.parseInt(t[1]);			
				
			out.println((b+c)%4);
			output.println((b+c)%4);				
		
		}
	
	input.close();
	output.close();	
	}
}