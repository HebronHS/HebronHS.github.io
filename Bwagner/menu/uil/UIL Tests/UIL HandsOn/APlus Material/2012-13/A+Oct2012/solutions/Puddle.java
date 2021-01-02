import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Puddle
{
	public static char[][] mat;
	
	public static void main(String[] args) throws IOException
	{
		int i,a,b,r,c,d;
		
		String s,s1;
		String[] t;
		r=c=0;
		
		Scanner input = new Scanner(new File("puddle.dat"));
		PrintWriter output = new PrintWriter(new File("puddle.out"));	
		
		s=input.nextLine().trim();
		t=s.split("\\s+");
		
		a=Integer.parseInt(t[0]);
		b=Integer.parseInt(t[1]);
		mat=new char[a][b];		
		
		for(r=0;r<a;r++)
		{
			s=input.nextLine();
			//out.println(s);
			for(c=0;c<b;c++)
			{
				mat[r][c]=s.charAt(c);
			}			
		}
		
		s=input.nextLine().trim();
		d=Integer.parseInt(s);
			
		for( i=0;i<d;i++)
		{		
			s=input.nextLine().trim();
			t=s.split("\\s+");
			
			a=Integer.parseInt(t[0]);
			b=Integer.parseInt(t[1]);
			
			if(mat[a][b]=='G')
			{
				out.println("OK");
				output.println("OK");
				
			}
			else if(mat[a][b]=='W')
			{
				out.println("PUDDLE");
				output.println("PUDDLE");
				freeze(a,b);
			}
			else if(mat[a][b]=='R' || mat[a][b]=='S')
			{
				out.println("OOPS");
				output.println("OOPS");
				
			}			
		}
		
		out.println();output.println();
		
		for(r=0;r<mat.length;r++)
		{		
			for(c=0;c<mat[0].length;c++)
			{
				out.print(mat[r][c]);
				output.print(mat[r][c]);
			}out.println();output.println();			
		}	
	
	
	input.close();
	output.close();	
	}
	
	public static void freeze(int row,int col)
	{
					
		if(row>=0 && row<mat.length && col>=0 && col<mat[0].length && mat[row][col]=='W')
		{
			mat[row][col]='F';
			freeze(row-1,col);
			freeze(row+1,col);
			freeze(row,col-1);
			freeze(row,col+1);
		}
		
	
	
	}
}