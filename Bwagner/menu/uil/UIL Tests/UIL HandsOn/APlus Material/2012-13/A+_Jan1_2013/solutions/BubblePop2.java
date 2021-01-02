import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class BubblePop2
{
	public static char[][] mat;
	public static int count,xf,yf;
	
	public static void main(String[] args) throws IOException
	{
		int i,a,b,r,c,d,e;
		
		String s,s1;
		String[] t;
		r=c=0;
		char ch;
			
		Scanner input = new Scanner(new File("bubblepop2.dat"));
		PrintWriter output = new PrintWriter(new File("bubblepop2.out"));	
		
		mat=new char[10][10];		
		
		for(r=0;r<10;r++)
		{
			s=input.nextLine();
			//out.println(s);
			for(c=0;c<10;c++)
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
			
			ch=mat[a][b];
		
			pop(a,b,ch);
			
			while(findBlanks())
			{				
				for(e=xf;e>0;e--)
				{
					mat[e][yf]=mat[e-1][yf];
				}
				mat[0][yf]='X';
			}								
		}
		
		e=0;
		
		for(r=0;r<mat.length;r++)
		{		
			for(c=0;c<mat[0].length;c++)
			{
				ch=mat[r][c];
				if(ch!='X')
				{
					count=0;
					rec(r,c,ch);
					//out.print(count+" ");
					if(count>2)
					 e++;
				}
			}
		}
		if(e==0)
		{
			out.println("GAME OVER\n");
			output.println("GAME OVER");output.println();
		}		
		
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
	
	public static void rec(int row,int col,char c)
	{					
		if(row>=0 && row<mat.length && col>=0 && col<mat[0].length && mat[row][col]==c)
		{
			count++;
			mat[row][col]='*';
			rec(row-1,col,c);
			rec(row+1,col,c);
			rec(row,col-1,c);
			rec(row,col+1,c);
			mat[row][col]=c;
		}	
	}
	
	public static void pop(int row,int col,char c)
	{
		if(row>=0 && row<mat.length && col>=0 && col<mat[0].length && mat[row][col]==c)
		{
			mat[row][col]='*';
			pop(row-1,col,c);
			pop(row+1,col,c);
			pop(row,col-1,c);
			pop(row,col+1,c);
		}
		
	}
	
	public static boolean findBlanks()
	{
		int i,j,k;
		for(i=0;i<mat.length;i++)
		 for(j=0;j<mat[0].length;j++)
		 {		 	
		 	if(mat[i][j]=='*')
		 	{
		 		xf=i; yf=j;
		 		return true;
		 	}		 	
		 }
		 return false;
	}
}