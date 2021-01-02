import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class DimeSweeper
{
	private static char[][] mat;
	
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,e,f,g,h,r;
		String s;
		String[] t;
		boolean over = false;
		char[][] temp;
		
				
		Scanner input = new Scanner(new File("dimesweeper.dat"));
		PrintWriter output = new PrintWriter(new File("dimesweeper.out"));
		s=input.nextLine().trim();
		t=s.split("\\s+");
		a=Integer.parseInt(t[0]);	
		b=Integer.parseInt(t[1]);
		mat = new char[a][b];
		temp=new char[a][b];
		
		for( r=0;r<a;r++)
		{
			s=input.nextLine().trim();
						
			for(c=0;c<s.length();c++)
			{
				temp[r][c]=mat[r][c]=s.charAt(c);
			}
		}
			
		/*for(r=0;r<mat.length;r++)
		{
			for(c=0;c<mat[0].length;c++)
			{
				out.print(mat[r][c]);
				output.print(mat[r][c]);
			}
			out.println();output.println();
		}
		out.println();output.println();
		*/	//output.println();		
		d=Integer.parseInt(input.nextLine().trim());				
		for(e=0;e<d;e++)
		{
			over=false;
			if(e>0)
			{			
				for(r=0;r<mat.length;r++)
				 for(c=0;c<mat[0].length;c++)
					mat[r][c]=temp[r][c];				
			}
			
			f=Integer.parseInt(input.nextLine().trim());
			
			
			for(i=0;i<f;i++)
			{
				//out.println(i);
				s=input.nextLine().trim();
				t=s.split("\\s+");
				g=Integer.parseInt(t[1]);
				h=Integer.parseInt(t[2]);
			
				if(t[0].equals("R"))
				{
					if(mat[g][h]=='D')
					 mat[g][h]='F';
					
				}
				else
				{
					if(mat[g][h]=='D')
					{
						over = true;
						out.println("GAME OVER");output.println("GAME OVER");
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
						
					}
					if(mat[g][h]=='0')
					{
						//out.println("RECURSION!!");
						sweep(g,h);
					}
				}
			}
			
			if(!over)
			{
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
				
			}
		}			
	
	input.close();
	output.close();	
	}
	public static void sweep(int r,int c)
	{
		if(r>=0 && r< mat.length && c >= 0 && c<mat[0].length && mat[r][c]=='0')
		{
			mat[r][c]=' ';
			sweep(r+1,c);
			sweep(r+1,c+1);
			sweep(r+1,c-1);
			sweep(r,c+1);
			sweep(r,c-1);
			sweep(r-1,c);
			sweep(r-1,c+1);
			sweep(r-1,c-1);
			
		}
	}
}