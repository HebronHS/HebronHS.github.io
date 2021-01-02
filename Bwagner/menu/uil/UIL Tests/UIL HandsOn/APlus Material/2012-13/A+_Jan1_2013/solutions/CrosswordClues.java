import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class CrosswordClues
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d;	
				
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> matches = new ArrayList<String>();
		
		String s,s1;
		String[] t;
		
		Scanner input = new Scanner(new File("crosswordclues.dat"));
		PrintWriter output = new PrintWriter(new File("crosswordclues.out"));	
							
		for(i=0;i<10;i++)
		{
			s=input.nextLine().trim();
			t=s.split("\\s+");
						
			for(String s2:t)
			{
				list.add(s2);
			}					
		}	
		
		//out.println(list.size()+" "+list);
		
		while(input.hasNextLine())
		{
			matches.clear();
			s=input.nextLine().trim();
			for(String s2:list)
			{
				if(s.length()==s2.length())
				{
					//out.println("check "+s+" "+s2);
					c=0;
					for(a=0;a<s.length();a++)
					{
						if(s.charAt(a)=='*' || s.charAt(a)==s2.charAt(a))
						{
							c++;
						}	
					}
					if(c==s.length())
					 matches.add(s2);
				}
			}
			
			//out.println(matches);
			if(matches.size()==0)
			{
				out.println("NO MATCH");
				output.println("NO MATCH");
			}
			else
			{
				for(String ss:matches)
				{
					out.print(ss+" ");
					output.print(ss+" ");
				}out.println();output.println();
					
			}
			
		}
		
	input.close();
	output.close();	
	}
	

}