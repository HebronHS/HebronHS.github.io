import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class KoolAid
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c;	
		
		String s,s1;
		
		Scanner input = new Scanner(new File("koolaid.dat"));
		PrintWriter output = new PrintWriter(new File("koolaid.out"));	
				
		a=Integer.parseInt(input.nextLine().trim());
			
		for(i=0;i<a;i++)
		{
			b=Integer.parseInt(input.nextLine().trim());
			
			if(b>=4)
			{
				out.print(b/4+" large ");
				output.print(b/4+" large ");
			}
						
			if(b%4==3)
			{
				out.print("1 medium 1 small");
				output.print("1 medium 1 small");
			}
			else if(b%4==2)
			{
				out.print("1 medium");
				output.print("1 medium");
			}
			else if(b%4==1)
			{
				out.print("1 small");
				output.print("1 small");
			}
			out.println();
			output.println();			
		}	
	
	input.close();
	output.close();	
	}
	

}