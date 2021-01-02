import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Similar
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,x,y,z;
		
		String s,s1;
		String[] t;
	
		Scanner input = new Scanner(new File("similar.dat"));
		PrintWriter output = new PrintWriter(new File("similar.out"));		
			
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{			
			s=input.nextLine().trim();	
			t=s.split("\\s+");
			
			b=Integer.parseInt(t[0]);
			c=Integer.parseInt(t[1]);
			d=Integer.parseInt(t[2]);
			x=Integer.parseInt(t[3]);
			y=Integer.parseInt(t[4]);
			
			z=d*x/b;
			
			out.println(x+" "+y+" "+z);
			output.println(x+" "+y+" "+z);
				
								  
		}
		
	input.close();
	output.close();	
	}
}