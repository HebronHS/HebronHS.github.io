import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class War
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,tot1,tot2,hand1,hand2;
		
		String s,s1;
		String[] t;
		ArrayList<String> p1, p2;
		p1 = new ArrayList<String>();
		p2 = new ArrayList<String>();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("2",2);map.put("3",3);map.put("4",4);map.put("5",5);
		map.put("6",6);map.put("7",7);map.put("8",8);map.put("9",9);
		map.put("10",10);map.put("J",11);map.put("Q",12);map.put("K",13);
		map.put("A",14);		
		
		Scanner input = new Scanner(new File("war.dat"));
		PrintWriter output = new PrintWriter(new File("war.out"));		
		 
	
		
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
			
			s=input.nextLine().trim();	
			t=s.split("\\s+");
			for(String s2:t)
			 p1.add(s2);
			 
			s=input.nextLine().trim();	
			t=s.split("\\s+");
			for(String s2:t)
			 p2.add(s2); 
			tot1=tot2=0;		
				
			while(p1.size()>0)
			{
				hand1=map.get(p1.get(0));
				hand2=map.get(p2.get(0));
				
				if(hand1>hand2)
				{
					tot1+=2;
					p1.remove(0);
					p2.remove(0);
				}
				else if(hand2>hand1)
				{
					tot2+=2;
					p1.remove(0);
					p2.remove(0);
				}
				else
				{
					p1.remove(0);p1.remove(0);p1.remove(0);p1.remove(0);
					p2.remove(0);p2.remove(0);p2.remove(0);p2.remove(0);
					hand1=map.get(p1.get(0));
					hand2=map.get(p2.get(0));
					if(hand1>hand2)
					{
						tot1+=10;
						p1.remove(0);
						p2.remove(0);
					}
					else
					{
						tot2+=10;
						p1.remove(0);
						p2.remove(0);
					}
					
				}				  
			}			
						
			out.println(tot1+" "+tot2);
			
			output.println(tot1+" "+tot2);
			//p1.clear();p2.clear();
		}
	
	input.close();
	output.close();	
	}
}