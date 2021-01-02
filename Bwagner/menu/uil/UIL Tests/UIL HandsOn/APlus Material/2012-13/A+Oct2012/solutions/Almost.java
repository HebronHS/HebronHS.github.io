import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Almost
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,r,c,d;
		
		String s,s1;
		String[] t;
		char[][] mat = new char[3][3];	
		char temp;
		r=c=0;
		
		Scanner input = new Scanner(new File("almost.dat"));
		PrintWriter output = new PrintWriter(new File("almost.out"));	
		
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
			for(r=0;r<3;r++)
			{
				s=input.nextLine();
				//out.println(s);
				for(c=0;c<3;c++)
				{
					mat[r][c]=s.charAt(c);
				}
				
				
			}
			
			
			
			
			for(r=0;r<3;r++)
			{
				
								
				for(c=0;c<3;c++)
				{
					
					if(mat[r][c]==' ')
					{
						temp=mat[r][c];
						mat[r][c]='X';
						
						
						if(check(mat))
						{
							out.println((r+1)+" "+(c+1));
							output.println((r+1)+" "+(c+1));
						}
						  
						mat[r][c]=temp; 
					} 
				}
				
				
				//out.println();
				
				
			}
			
			
		}	
	
	
	input.close();
	output.close();	
	}
	
	public static boolean check(char[][] mat)
	{
		int r,c;
		boolean tf=false;
		
		for(r=0;r<3;r++)
		{
			// check horizontal wins
			if(mat[r][0]=='X' && mat[r][1]=='X' && mat[r][2]=='X')
			 tf=true;
			//check vertical wins
			if(mat[0][r]=='X' && mat[1][r]=='X' && mat[2][r]=='X')
			 tf=true;			
			
		}
		if(mat[0][0]=='X' && mat[1][1]=='X' && mat[2][2]=='X')
			 tf=true;
		if(mat[0][2]=='X' && mat[1][1]=='X' && mat[2][0]=='X')
			 tf=true;
		
		
		return tf;
	}
}