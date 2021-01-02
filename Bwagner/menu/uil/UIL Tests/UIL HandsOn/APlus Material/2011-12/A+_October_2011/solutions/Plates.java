import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Plates
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,e,f;
		
		String s1,s2,s3;
		String[] t;
		ArrayList<String> list = new ArrayList<String>();
		boolean done= false;
		
		Scanner input = new Scanner(new File("plates.dat"));
		PrintWriter output = new PrintWriter(new File("plates.out"));
		a=Integer.parseInt(input.nextLine().trim());
		
		for(i=0;i<a;i++)
		{
			s1=input.nextLine().trim();
			t=s1.split("\\s+");
			s3="";
			done=false;
			
			if(t.length==1)
			{
				//one word
				for(b=0;b<s1.length();b++)
				{
					if(s1.length()<=8) break; 
					
					if(isVowel(s1.charAt(b)))
					 s1=s1.substring(0,b)+s1.substring(b+1);
					
					
				}
				s3=s1;
			}
			else
			{
				list.clear();
				for(String ss:t)
				{
					list.add(ss);
					s3+=ss;
				}
				if (s3.length()<=8)
				 done=true;
				 
				while(!done)
				{
					for(d=0;d<list.size();d++)
					{
						s1=list.get(d);
						c=firstVowel(s1);
						//out.println("    c="+c+" in word "+s1);
						if(c>=0)
						{
							s1=s1.substring(0,c)+s1.substring(c+1);
							list.set(d,s1);
						}
						
						s3="";
						for(String ss: list)
						 s3+=ss;
						 
						if(s3.length()<=8)
						{
							done=true;
							break;
						}
						
				 		//out.println("        in loop "+s3);	
				 		
				 	} 
						 
					if(firstVowel(s3)==-1) done=true;
				} 
			}
			if(s3.length()>8)
			{
				out.println(s3.substring(0,8));
				output.println(s3.substring(0,8));
			}
			 
			else
			{
				out.println(s3);
				output.println(s3);
			}		
			 
		
		}
	
	input.close();
	output.close();	
	}
	
	public static boolean isVowel(char c)
	{
		if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
		 return true;
		else
		 return false; 
	}
	
	public static int firstVowel(String s)
	{
		for(int i=0;i<s.length();i++)
		 if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' ||
		    s.charAt(i)=='o' || s.charAt(i)=='u')
		     return i;
		
		
		return -1;      
	}
}