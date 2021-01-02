import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Shy
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c;
		
		String s;
		StringBuffer u;
		String[] t;
		Scanner input = new Scanner(new File("shy.dat"));
		PrintWriter output = new PrintWriter(new File("shy.out"));
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			b=s.length();
			
			u=new StringBuffer(s);
			
			if(s.charAt(0)=='f')
			 u.setCharAt(0,'o');
			 
			if(s.charAt(b-1)=='f')
			 u.setCharAt(b-1,'o');
			
			for(c=1;c<b-1;c++)
			{
				//out.println(c);
				if(s.charAt(c)!='x' && s.charAt(c-1)!='x' && s.charAt(c+1)!='x')
				 u.setCharAt(c,'o');
			}		
						
			//out.println(s);
			out.println(u);
			output.println(u);
		
		}
	
	input.close();
	output.close();	
	}
}