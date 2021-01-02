import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Mean
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,total=0;
		double mean,median,mode;
		mean=median=mode=0.0;
		
		String s,s1;
		String[] t;
		ArrayList<Integer> list=new ArrayList<Integer>();
		TreeMap<String,Integer> map = new TreeMap<String,Integer>();
		TreeMap<Integer,String> map2 = new TreeMap<Integer,String>();
				
		Scanner input = new Scanner(new File("mean.dat"));
		PrintWriter output = new PrintWriter(new File("mean.out"));		
			
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		out.println("mean median mode");
		output.println("mean median mode");
		
		for( i=0;i<a;i++)
		{
			total=0;
			mean=median=mode=0.0;
			map.clear();
			map2.clear();
			list.clear();
			
			s=input.nextLine().trim();	
			t=s.split("\\s+");
			for(String s2:t)
			{
				d=Integer.parseInt(s2);
				if(map.get(s2)==null)
				{
					map.put(s2,1);					
				}
				else
				{
					map.put(s2,map.get(s2)+1);
				}				
				
				total+=d;
				list.add(d);
			}			 
			Collections.sort(list);
			
			b=list.size();
			c=b/2;
			
			//out.println("total="+total+" size="+b);
			
			mean=1.0*total/b;
			
			if(b%2==0)
			 median=(list.get(c)+list.get(c-1))/2.0; 
			else
			 median=list.get(c);
			
			// reverse the map<String,Integer> to find max # times
			//out.println(map);
			
			for(String s2:map.keySet())
			{
				d=map.get(s2);
				map2.put(d,s2);
			}
			
			//out.println(map2);
			//out.println(map.lastEntry().getKey());
			 
			mode=Double.parseDouble(map2.lastEntry().getValue());
			
			out.printf("%4.1f %6.1f  %4.1f%n",mean,median,mode);
			output.printf("%4.1f %6.1f %4.1f%n",mean,median,mode);		
								  
		}
		
	input.close();
	output.close();	
	}
}