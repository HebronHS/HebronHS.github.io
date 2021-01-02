import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Synonyms
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,total=0;
		
		String s,s1;
		String[] t;
		
		ArrayList<String> paragraph=new ArrayList<>();
		ArrayList<String> synonyms=new ArrayList<>();
		ArrayList<String> temp=new ArrayList<>();
		
		TreeMap<String,ArrayList<String>> map = new TreeMap<>();
						
		Scanner input = new Scanner(new File("synonyms.dat"));
		PrintWriter output = new PrintWriter(new File("synonyms.out"));		
			
		s=input.nextLine().trim();
		a=Integer.parseInt(s);	
		
		for( i=0;i<a;i++)
		{
			paragraph.add(input.nextLine().trim());
			
		}
		
		b=Integer.parseInt(input.nextLine().trim());
		for(i=0;i<b;i++)
		{
			synonyms=new ArrayList<>();
			s=input.nextLine();
			t=s.split("\\s+");
			
			for(c=0;c<t.length;c++)
			{
				synonyms.add(t[c]);
			}
			map.put(t[0],synonyms);
			//out.println("---"+synonyms);
		}
		
		for( i=0;i<a;i++)
		{
			s=paragraph.get(i);
			t=s.split("\\s+");
			for(String ss:t)
			{
				if(map.containsKey(ss))
				{
					//out.println("found it "+ss);
					temp=map.get(ss);
					//out.println(temp);
					s1=temp.remove(0);
					out.print(s1+" ");
					output.print(s1+" ");					
				}
				else
				{
					out.print(ss+" ");
					output.print(ss+" ");
				}
				
			}
			out.println();
			output.println();
		}		
		
	input.close();
	output.close();	
	}
}