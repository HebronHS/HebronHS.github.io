import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Wavey
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,e,f,g,r;
		String s;
		String[][] mat;
				
		Scanner input = new Scanner(new File("wavey.dat"));
		PrintWriter output = new PrintWriter(new File("wavey.out"));
		s=input.nextLine().trim();
		a=Integer.parseInt(s);	
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			b=s.length();
			mat = new String[b][4*b-3];
			
			for(r=0;r<mat.length;r++)
			{
				for(c=0;c<mat[0].length;c++)
				{
					mat[r][c]=" ";
				}
			}
			
			d=0;e=2*b-2; f=e;g=4*b-4;
			for(c=0;c<b;c++)
			{
				mat[c][d]=mat[c][e]=mat[c][f]=mat[c][g]=s.substring(c,c+1);
				d++;
				e--;
				f++;
				g--;
			}
			
			for(r=0;r<mat.length;r++)
			{
				for(c=0;c<mat[0].length;c++)
				{
					out.print(mat[r][c]);
					output.print(mat[r][c]);
				}
				out.println();output.println();
			}
			out.println();output.println();
			//output.println();		
						
		}
		
				
	
	input.close();
	output.close();	
	}
}