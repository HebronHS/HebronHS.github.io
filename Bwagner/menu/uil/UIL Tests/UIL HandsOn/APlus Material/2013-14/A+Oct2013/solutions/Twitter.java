import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Twitter
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,total=0;
			
		String s,s1;
		//String[] t;
	
		Scanner input = new Scanner(new File("twitter.dat"));
		PrintWriter output = new PrintWriter(new File("twitter.out"));		
			
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		i=0;
		
		s=input.nextLine();
		b=s.length();
		
		while(input.hasNextLine())
		{
			
			s=input.nextLine();	
			b=s.length();
			
			if(s.charAt(0)=='@')// && i>0)
			{
				i++;
				
				if(total<=140 && i>0)
				{
					out.println("tweet");
					output.println("tweet");
				}
				else if(i>0)
				{
					out.println("not tweet");
					output.println("not tweet");
				}
						
				total=0;
			}
				
			total+=b;
			//out.println(i+" "+total);			
			  
		}
		
		if(total<=140)
		{
			out.println("tweet");
			output.println("tweet");
		}
		else
		{
			out.println("not tweet");
			output.println("not tweet");
		}
		
	input.close();
	output.close();	
	}
}