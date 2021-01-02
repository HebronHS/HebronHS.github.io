import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

/* This isn't an elegant solution, but it works. As I wrote the problem,
 * it didn't seem so bad.  Solving it was a totally different situation.
 * I am working on a better (probably recursion?) solution, and
 * if you generate one, please email me at wade.hood@canadianisd.net
*/
public class Combo
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,max,position;
		
		String s,s1,s2,combo,s3;
		String[] t;
		boolean funky=false;
		
		Scanner input = new Scanner(new File("combo.dat"));
		PrintWriter output = new PrintWriter(new File("combo.out"));
		ArrayList<String> list = new ArrayList<String>();
		TreeMap<String,Integer> m1,m2,m3,m4;// = new TreeMap<String,Integer>();
		Set set = new TreeSet<String>();
		TreeSet<String> whole=new TreeSet<String>();
		
		whole.add("0");whole.add("1");whole.add("2");whole.add("3");whole.add("4");
		whole.add("5");whole.add("6");whole.add("7");whole.add("8");whole.add("9");
		
		ArrayList<String> combination = new ArrayList<String>();
		ArrayList<String> others = new ArrayList<String>();
		a=Integer.parseInt(input.nextLine().trim());
		
		for( i=0;i<a;i++)
		{
			funky=false;position=-1;
			combo="";
			list.clear();
			list.add(input.next());list.add(input.next());
			list.add(input.next());list.add(input.next());
									
			m1=new TreeMap<String,Integer>();
			
			combination.clear();
			others.clear();
			
			for(b=0;b<4;b++) //  each of the four days of combos
			{
				
				max=0;
				s3="";
				m1=new TreeMap<String,Integer>();
				
				for(c=0;c<4;c++) //  each digit in the combo
				{
					
					s3=list.get(c).substring(b,b+1);
					if(m1.get(s3)==null)
					{
						m1.put(s3,1);
					}
					else
					{
						m1.put(s3,m1.get(s3)+1);
					}
				}
				
				//System.out.println("m1="+m1);
				
				if(m1.size()==1)
				{
					combo+=m1.firstKey();
					combination.add(m1.firstKey());
					
				}
				else if(m1.size()==2 || m1.size()==3)
				{
				
					for(String aa:m1.keySet())
					{
						if(m1.get(aa)>max)
						 {
						   s3=aa;
						   max=m1.get(aa);
						 }						
					}
					combo+=s3;
					combination.add(s3);
					// got the maximum!
				}
				else // size()==4
				{
					combination.add("X");
					funky=true;
					position=b;
					set=m1.keySet();
					for(String bb:whole)
					{
						if(!set.contains(bb))
						 others.add(bb);
					}						
					
				    //use ArrayList to add others = item in whole not in set
					//use all digits not in this keySet()
				}				
				//out.println("---"+combination);
						
			}
			if(funky)
			{
				//out.println(combination);
				//out.println("WHODAT"+position);
				//out.println(m1);
				//out.println(set);
				//out.println(others);
				for(String aa:others)
				{
					for(d=0;d<4;d++)
					{
						if(d==position)
						{
							 out.print(aa);output.print(aa);
						}
						else 
						{
							 out.print(combination.get(d));
							 output.print(combination.get(d));
						}
					}
					out.print(" ");output.print(" ");
				}
				out.println();output.println();
				
			}
			else
			{
				out.println(combo);output.println(combo);
			}				
		}
		
	input.close();
	output.close();	
	}
}