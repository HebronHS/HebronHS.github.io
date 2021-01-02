import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Satisfied
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,p,m;
		
		String s;
		//StringBuffer u;
		//String[] t;
		Scanner input = new Scanner(new File("satisfied.dat"));
		PrintWriter output = new PrintWriter(new File("satisfied.out"));
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			p=m=0;
			for(c=0;c<s.length();c++)
			{
				//out.println(c);
				if(s.charAt(c)=='p')
				 p++;
				else
				 m++; 				 
			}		
						
			//out.println(s);
			if(p==m)
			{
				out.println("Satisfied!");
				output.println("Satisfied!");
			}
			else if( p>m)
			{
				out.println("Eat "+(p-m)+" more M&M's.");
				output.println("Eat "+(p-m)+" more M&M's.");
			}
			else
			{
				out.println("Eat "+(m-p)+" more peanuts.");
				output.println("Eat "+(m-p)+" more peanuts.");
			}
			
		
		}
	
	input.close();
	output.close();	
	}
}