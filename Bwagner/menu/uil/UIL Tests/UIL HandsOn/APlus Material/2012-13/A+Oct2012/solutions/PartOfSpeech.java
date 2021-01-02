import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class PartOfSpeech
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d;
		
		String s,s1;
		String[] t;
		ArrayList<String> articles, verbs,sentence;
		articles = new ArrayList<String>();
		verbs = new ArrayList<String>();
		sentence = new ArrayList<String>();
		
		Scanner input = new Scanner(new File("partofspeech.dat"));
		PrintWriter output = new PrintWriter(new File("partofspeech.out"));
		
		s=input.nextLine().trim();	
		t=s.split("\\s+");
		for(String s2:t)
		 articles.add(s2);
		 
		s=input.nextLine().trim();	
		t=s.split("\\s+");
		for(String s2:t)
		 verbs.add(s2); 
		 
		s=input.nextLine().trim();	
		t=s.split("\\s+");
		for(String s2:t)
		 verbs.add(s2);  
		
		//out.println(articles);
		//out.println(verbs);
		
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			t=s.split("\\s+");
			s1=t[0];
			b=Integer.parseInt(t[1]);	
			
			for(c=0;c<b;c++)
			{
				s=input.nextLine().trim();
				s=s.substring(0,s.length()-1).toLowerCase();	
				t=s.split("\\s+");
				for(String s2:t)
				 sentence.add(s2);
				 
				d=sentence.indexOf(s1);
				
				//out.println(d);
				//out.println(sentence);
				
				if(articles.indexOf(sentence.get(d-1)) >=0 )
				{
					out.println("NOUN");
					output.println("NOUN");					
				}
				 
				else
				{
					out.println("VERB");
					output.println("VERB");					
				}
				sentence.clear();
				
				  
			}			
						
			out.println();
			output.println();
		
		}
	
	input.close();
	output.close();	
	}
}