import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class DeerTags
{	
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,total;
		boolean done=true;
		TreeMap<String,String> map = new TreeMap<String,String>();
		TreeMap<String,Integer> map1 = new TreeMap<String,Integer>();
		TreeMap<Integer,String> map2 = new TreeMap<Integer,String>();		
		
		String s,s1,tag;
		String[] t;		
		
		Scanner input = new Scanner(new File("deertags.dat"));
		PrintWriter output = new PrintWriter(new File("deertags.out"));		
		
		total=b=0;
		 
		while(input.hasNextLine())
		{
			s=input.nextLine().trim();	
			tag=s.substring(0,4);
			s1=s.substring(5);			
			map.put(tag,s1);				
		}
		
		//out.println(map);
		
		map1.put("DEAD - NATURAL CAUSES",0);
		map1.put("DEAD - COYOTE",0);
		map1.put("DEAD - MOUNTAIN LION",0);
		map1.put("DEAD - BEAR",0);
		
		//out.println(map1);
		
		for(String ss : map.keySet())
		{
			s1=map.get(ss);
			if(s1.equals("NEW") || s1.equals("OK"))
			{
				b++;
			}
			else
			{
				c=map1.get(s1);
				map1.put(s1,c+1);								
			}
		}
		
		total+=b;
		
		for(String ss : map1.keySet())
		{
			c=map1.get(ss);
			map2.put(c,ss);
			total+=c;
		}
		
		out.println("ALIVE " + Math.round(100.*b/total)+"%");
		output.println("ALIVE " + Math.round(100.*b/total)+"%");
		
		for(Integer ii : map2.descendingKeySet())
		{
			s=map2.get(ii);
			out.println(s.substring(7)+" "+Math.round(100.0*ii/total)+"%");
			output.println(s.substring(7)+" "+Math.round(100.0*ii/total)+"%");			
		}
		
		//out.println(b);
		//out.println(map2);		
	
	input.close();
	output.close();	
	}
}