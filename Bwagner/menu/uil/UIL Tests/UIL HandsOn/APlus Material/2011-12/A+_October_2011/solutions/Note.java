import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Note
{
	static String[][] mat;
	static String start;
	static String end;
	static String intercept;
	static boolean poss=false;
	static boolean interc=false;
	
	public static void main(String[] args) throws IOException
	{
		
		int i,j,a,b,c,d,e,f=0,g=0,h;
		
		String s,s1,s2,s3;
		String[] t;
		
		Scanner input = new Scanner(new File("note.dat"));
		PrintWriter output = new PrintWriter(new File("note.out"));
		s=input.nextLine().trim();
		t=s.split("\\s+");
		a=Integer.parseInt(t[0]);
		b=Integer.parseInt(t[1]);
		mat=new String[a][b];
		String[][] temp = new String[a][b];
		
		for(i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			for(c=0;c<s.length();c++)
			{
				mat[i][c]=temp[i][c]=""+s.charAt(c);
				
			}
		}
		
		/*for(i=0;i<a;i++)
		{
			for(j=0;j<b;j++)
			{
				out.print(mat[i][j]);
			}out.println();
		}*/
		
		d=Integer.parseInt(input.nextLine().trim());
		for(e=0;e<d;e++)
		{
			s1=input.nextLine().trim();
			
			for(i=0;i<a;i++)
			{
				for(j=0;j<b;j++)
				{
					if(mat[i][j].equals(""+s1.charAt(0)))
					{
						f=i;g=j;
					}
					
				}
				
			}
			poss=interc=false;
			
			start=""+s1.charAt(0);
			end=""+s1.charAt(1);
			intercept=""+s1.charAt(2);
			
			for(i=0;i<a;i++)
			{
				for(j=0;j<b;j++)
				{
					mat[i][j]=temp[i][j];
				}
			}
			
			//out.println("END="+end);
			if(Character.isLowerCase(s1.charAt(0)))
			 boy(f,g);
			else
			 girl(f,g);//out.println("NOT YET")
			 			  
			//out.println("poss = "+poss);
			//out.println("interc = "+interc); 
			
			/*for(i=0;i<a;i++)
			{
				for(j=0;j<b;j++)
				{
					out.print(mat[i][j]);
				}out.println();
			}*/
			
			for(i=0;i<a;i++)
			{
				for(j=0;j<b;j++)
				{
					mat[i][j]=temp[i][j];
				}
			}
			
			if(poss)
			{
				if(interc)
				{
					out.println("INTERCEPTED");
					output.println("INTERCEPTED");
				}
				else
				{
					out.println("POSSIBLE");
					output.println("POSSIBLE");
					
				}
				 
			}
			else
			{
				out.println("IMPOSSIBLE");
				output.println("IMPOSSIBLE");
				
			}	
			
		}		
	
	input.close();
	output.close();	
	}
	
	public static void boy(int row, int col)
	{
		if(row>=0 && row<mat.length && col >=0 && col< mat[0].length && 
		Character.isLowerCase(mat[row][col].charAt(0)))
		{
			if(mat[row][col].equals(end))
			{
				poss=true;
			}
			if(mat[row][col].equals(intercept))
			{
				interc=true;
			}
			mat[row][col]=".";
			boy(row+1,col);
			boy(row-1,col);
			boy(row,col+1);
			boy(row,col-1);
		}		
	}
	
	public static void girl(int row, int col)
	{
		if(row>=0 && row<mat.length && col >=0 && col< mat[0].length && 
		Character.isUpperCase(mat[row][col].charAt(0)))
		{
			if(mat[row][col].equals(end))
			{
				poss=true;
			}
			if(mat[row][col].equals(intercept))
			{
				interc=true;
			}
			mat[row][col]=".";
		    girl(row+1,col);
			girl(row-1,col);
			girl(row,col+1);
			girl(row,col-1);
		}		
	}
	
	
}