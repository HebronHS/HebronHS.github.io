import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class CSMeals
{
	public static void main(String[] args) throws IOException
	{
		int i,j,a,b,c,d,x,y,z;
						
		String s,s1;
		String[] t;
		
		ArrayList<String> grocery = new ArrayList<>();
		ArrayList<String> receipt = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();
		
		Scanner input = new Scanner(new File("csmeals.dat"));
		PrintWriter output = new PrintWriter(new File("csmeals.out"));		
			
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{			
			s=input.nextLine().trim();	
			b=Integer.parseInt(s);
			for(j=0;j<b;j++)
			{
				s=input.nextLine().trim();
				t=s.split("\\s+");
				
				for(String s2:t)
				 grocery.add(s2);				 
			}
			
			for(j=0;j<b;j++)
			{
				s=input.nextLine().trim();
				t=s.split("\\s+");
				
				for(String s2:t)
				 receipt.add(s2);				 
			}		
			
			if(grocery.size()>receipt.size())
			{
				// need more
				out.print("BUY MORE ");
				output.print("BUY MORE ");
				for(String s3:grocery)
				{
					if(!receipt.contains(s3))
					{
						temp.add(s3);
						out.print(s3+" ");
						output.print(s3+" ");
					}
				}
				out.println();
				output.println();
			}
			else if(grocery.size()==receipt.size())
			{
				// OK
				out.println("OK");
				output.println("OK");
				
			}
			else
			{
				// put back
				out.print("PUT BACK ");
				output.print("PUT BACK ");
				for(String s3:receipt)
				{
					if(!grocery.contains(s3))
					{
						temp.add(s3);
						out.print(s3+" ");
						output.print(s3+" ");
					}
				}
				out.println();
				output.println();				
			}
			
		
			grocery.clear();
			receipt.clear();
			temp.clear();					  
		}
		
	input.close();
	output.close();	
	}
}