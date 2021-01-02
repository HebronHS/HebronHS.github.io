import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Periodic2
{	
	public static ArrayList<String> m1 = new ArrayList<String>();
	public static ArrayList<String> m2 = new ArrayList<String>();
	public static boolean done;
	
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,tot1,tot2,hand1,hand2;
		//boolean done=true;
		
		String s,s1;
		String[] t;		
		
		Scanner input = new Scanner(new File("periodic2.dat"));
		PrintWriter output = new PrintWriter(new File("periodic2.out"));		
		 
		for( i=0;i<4;i++)
		{
			s=input.nextLine().trim().toLowerCase();	
			t=s.split("\\s+");
			for(String s2:t)
			{
				if(s2.length()==1)
				 m1.add(s2);
				else
				 m2.add(s2); 
			}			
		}
		
		//out.println(m1);
		//out.println(m2);
		
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{			
			s=input.nextLine().trim();			
			done=false;			
			//out.println(s);
			rec(s);
									
			if(done)
			{
				out.println("yes");
				output.println("yes");
			}
			else
			{
				out.println("no");
				output.println("no");
			}		
		
		}
	
	input.close();
	output.close();	
	}
	
	public static void rec(String chopped)
	{
		//out.println(chopped);
		if(chopped.length()==0)
		{
			done=true;
			//out.println("SUCCESS");
		}
		 
		if(chopped.length()>0 && !done)
		{
			if(m1.contains(chopped.substring(0,1)))
			 rec(chopped.substring(1));
			
			if(chopped.length()>=2 && m2.contains(chopped.substring(0,2)))
			 rec(chopped.substring(2));
		}
	}
}