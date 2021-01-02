import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Checkers
{
	public static char[][] mat;
	public static int count;
	
	public static void main(String[] args) throws IOException
	{
		int i,a,b,r,c,d,e,r1,c1,pellets,y,z,max;
		
		char ch;
		boolean found=false,gameover=false;
		
		String s,s1,saved,last,current;
		String[] t;
		r=c=0;
		
		Scanner input = new Scanner(new File("checkers.dat"));
		PrintWriter output = new PrintWriter(new File("checkers.out"));	
				
		mat=new char[8][8];
			
		
		a=Integer.parseInt(input.nextLine().trim());
		for(b=0;b<a;b++)
		{
			saved="";
			count=0;
			max=0;		
			for(r=0;r<mat.length;r++)
			{
				s=input.nextLine();
				//out.println(s);
				for(c=0;c<mat[0].length;c++)
				{					
					mat[r][c]=s.charAt(c);
				}			
			}
			y=z=r1=c1=0;
		
			//find each red checker (R)
			for(c=mat.length-1;c>=0;c--)
			{			
				for(r=0;r<mat.length;r++)
				{
					if(mat[r][c]=='R')
					 {					 	
					 	y=r1=r; z=c1=c;
					 	//out.print("["+r+","+c+"]");
					 	count=0;
					 	//go for it!
					 	jump(r,c);
					 
					 	if(max<count)
					 	{
					 		max=Math.max(max,count);
					 		saved=""+r+" "+c+" "+max;
					 	}					 	
					 	//out.println("max="+max);				 	
					 	
					 }
				}			
			}
			
			//out.println(r1+" "+c1);
			
			out.println(saved); // end of data set
			output.println(saved);			
		}
	
		/*out.println();output.println();
		
		for(r=0;r<mat.length;r++)
		{		
			for(c=0;c<mat[0].length;c++)
			{
				out.print(mat[r][c]);
				output.print(mat[r][c]);
			}out.println();output.println();			
		}*/		
	
	input.close();
	output.close();	
	}
	
	public static void jump(int r,int c)
	{
		if(r>1 && c>1 && mat[r-1][c-1]=='B' && mat[r-2][c-2]==' ') //jump up&left
		{
			//out.println("in jump1 "+r+c);
			
			mat[r-2][c-2]='R';
			mat[r][c]=' ';
			jump(r-2,c-2);
			
			count++;
			
			mat[r][c]='R';
			mat[r-2][c-2]=' ';
		}
		
		if(r>1 && c<mat.length-2 && mat[r-1][c+1]=='B' && mat[r-2][c+2]==' ') // jump up&right
		{
			//out.println("in jump2 "+r+c);
			
			mat[r-2][c+2]='R';
			mat[r][c]=' ';
			jump(r-2,c+2);
			
			count++;
			
			mat[r][c]='R';
			mat[r-2][c+2]=' ';
			
		}		
	}
}