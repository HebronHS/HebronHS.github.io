import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Vowely
{	
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d;				
		String word,vowels="aeiou",part;
		String[] t;		
		
		Scanner input = new Scanner(new File("vowely.dat"));
		PrintWriter output = new PrintWriter(new File("vowely.out"));		
		
		a=Integer.parseInt(input.nextLine().trim());
		
		for(i=0;i<a;i++)
		{
			word=input.nextLine().trim();	
			c=0;
			for(b=0;b<word.length();b++)
			{
				part=word.substring(b,b+1);
				if(vowels.contains(part))
				 c++;
			}
			if(2.0*c>= word.length())
			{
				out.println("YES");
				output.println("YES");
			}
			else
			{
				out.println("NO");
				output.println("NO");
			}						
		}		
	
	input.close();
	output.close();	
	}
}