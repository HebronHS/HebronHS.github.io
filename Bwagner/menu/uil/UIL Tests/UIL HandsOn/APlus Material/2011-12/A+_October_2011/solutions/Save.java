import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Save
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,e,f;
		double P,M,r,n;
		String s1,s2,s3;
		String[] t;
		
		Scanner input = new Scanner(new File("save.dat"));
		PrintWriter output = new PrintWriter(new File("save.out"));
		a=Integer.parseInt(input.nextLine().trim());
		
		for(i=0;i<a;i++)
		{
			s1=input.nextLine().trim();
			t=s1.split("\\s+");
			
			
			P=Double.parseDouble(t[0]);
			n=Double.parseDouble(t[1]);
			r=Double.parseDouble(t[2])/1200.0;
			
			M=(P*(Math.pow(1+r,n)-1))/(r);
			
			out.printf("$%,.2f ",(M));
			out.println();
				
			output.printf("$%,.2f ",(M));
			output.println();			
			
		
		}
	
	input.close();
	output.close();	
	}
}