import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Snake
{
	//public static char[][] mat;
	
	public static void main(String[] args) throws IOException
	{
		int i,a,b,r,c,d,e,r1,c1,pellets,y,z;
		char[][] mat;
		char[][] copy;
		char ch;
		boolean found=false,gameover=false;
		
		String s,s1,last,current;
		String[] t;
		r=c=0;
		
		Scanner input = new Scanner(new File("snake.dat"));
		PrintWriter output = new PrintWriter(new File("snake.out"));	
				
		mat=new char[15][15];
		copy=new char[15][15];		
		
		for(r=0;r<15;r++)
		{
			s=input.nextLine();
			//out.println(s);
			for(c=0;c<15;c++)
			{
				copy[r][c]=mat[r][c]=s.charAt(c);
			}			
		}
		y=z=r1=c1=0;
		found=false;
		
		//find the rightmost X - search
		for(c=14;c>=0&&!found;c--)
		{			
			for(r=0;r<15;r++)
			{
				if(mat[r][c]=='X')
				 {y=r1=r; z=c1=c;found=true; break;}
			}			
		}
		
		//out.println(r1+" "+c1);
				
		s=input.nextLine().trim();
		d=Integer.parseInt(s);
			
		for( i=0;i<d;i++)
		{
			r1=y;c1=z;
			gameover=false;	
			pellets=0;
			s=input.nextLine().trim();
			last="R";
			for(e=0;e<s.length();e++)
			{
				current=s.substring(e,e+1);
				//out.print(current+" ");
				switch(current)
				{
					 
					case "U":r1--;last=current;	
					break;
					case "R":c1++;last=current;	
					break;
					case "L":c1--;last=current;	
					break;
					case "D":r1++;last=current;	
					break;
					case "O":
					  switch(last)
					  {
						  	case "U":r1--;
							break;
							case "R":c1++;
							break;
							case "L":c1--;
							break;
							case "D":r1++;
							break;
					  }
					break;					
				}
				
				//out.println(r1+" "+c1);
				
				if(r1<0 || r1> 14 || c1<0 || c1>14)
				{
					gameover=true;
					break;
				}
				else if(mat[r1][c1]=='F')
				{
					pellets++;
				}
				
				
				//last=current;	
			}
			//out.println();	
			if(gameover)
			  { out.println("GAME OVER"); output.println("GAME OVER");  } 
			else
			  { out.println(pellets+" pellets"); output.println(pellets+" pellets"); }			
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
}