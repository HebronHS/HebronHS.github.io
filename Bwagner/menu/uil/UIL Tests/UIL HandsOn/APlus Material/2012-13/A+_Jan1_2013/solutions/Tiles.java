import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Tiles
{	
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d;
		double x,y;				
		String s;
		String[] t;		
		
		Scanner input = new Scanner(new File("tiles.dat"));
		PrintWriter output = new PrintWriter(new File("tiles.out"));		
		
		a=Integer.parseInt(input.nextLine().trim());
		
		for(i=0;i<a;i++)
		{
			s=input.nextLine().trim();	
			t=s.split("\\s+");
			b=Integer.parseInt(t[0])*Integer.parseInt(t[1]);
			x=1.10*b;
			c=(int)(Math.ceil(1.10*b));
			//out.println(x%1);
			
			if(x%1 < 1.0e-8)
			 c--;
			
			out.println(c);
			output.println(c);
									
		}		
	
	input.close();
	output.close();	
	}
}