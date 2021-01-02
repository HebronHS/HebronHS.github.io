import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Climb
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,e,x,y,z;
		
		String s,s1;
		String[] t;
	
		Scanner input = new Scanner(new File("climb.dat"));
		PrintWriter output = new PrintWriter(new File("climb.out"));		
			
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{			
			s=input.nextLine().trim();	
			b=Integer.parseInt(s);
			for(c=0;c<b;c++)
			{
				for(d=b;d>0;d--)
				{
					if(c<d-1)
					{
						out.print(" ");	
						output.print(" ");	
					}
					else
					{
						out.print("C");
						output.print("C");
					}					
				}
				out.println();
				output.println();
						
				
			}
			out.println();	
			output.println();
		
								  
		}
		
	input.close();
	output.close();	
	}
}