import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class ForeignShoes
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c;	
		
		String s,s1;
		String[] t;
		
		Scanner input = new Scanner(new File("foreignshoes.dat"));
		PrintWriter output = new PrintWriter(new File("foreignshoes.out"));	
				
		a=Integer.parseInt(input.nextLine().trim());
			
		for(i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			t=s.split("\\s+");
			b=Integer.parseInt(t[2]);
			
			if(t[0].equals("Men"))
			{
				if(t[1].equals("UK"))
				{
					out.println("Men US "+(b+1));
					output.println("Men US "+(b+1));
				}
				else
				{
					out.println("Men UK "+(b-1));
					output.println("Men UK "+(b-1));
				}
			}
			else
			{
				if(t[1].equals("UK"))
				{
					out.println("Women US "+(b+2));
					output.println("Women US "+(b+2));
				}
				else
				{
					out.println("Women UK "+(b-2));
					output.println("Women UK "+(b-2));
				}
			}
			
			//out.println();
			//output.println();			
		}	
	
	input.close();
	output.close();	
	}
	

}