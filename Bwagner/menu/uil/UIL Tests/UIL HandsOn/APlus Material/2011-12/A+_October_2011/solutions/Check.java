import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Check
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,e,f;
		
		String s1,s2,s3;
		//String[] t;
		
		Scanner input = new Scanner(new File("check.dat"));
		PrintWriter output = new PrintWriter(new File("check.out"));
		a=Integer.parseInt(input.nextLine().trim());
		
		for(i=0;i<a;i++)
		{
			s1=input.nextLine().trim();
			s2=input.nextLine().trim();
			
			b=Integer.parseInt(s1);
			c=Integer.parseInt(s2.substring(1));
			d=b*(c%10);
			e=10*b*(c/10);	
			f=b*c;	 
			
			out.printf("%4s \n",s1);
			out.printf("%4s \n",s2);
			out.println("----");
			out.printf("%4d \n",d);
			out.printf("%4d \n",e);
			out.println("----");
			out.printf("%4d \n\n",f);
				
			output.printf("%4s",s1);output.println();
			output.printf("%4s",s2);output.println();
			output.println("----");
			output.printf("%4d",d);output.println();
			output.printf("%4d",e);output.println();
			output.println("----");
			output.printf("%4d",f);output.println();output.println();			
			
		
		}
	
	input.close();
	output.close();	
	}
}