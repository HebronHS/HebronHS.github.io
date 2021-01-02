//Solution - HeadLine News Packet - John Owen - 2011
//BedBugs

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class bedbugs
{

	public void run()throws Exception
	{
		Scanner f=new Scanner(new File("bedbugs.dat"));
		int N = f.nextInt();
		int w=0,h=0;
		while(N-->0)
		{
			String size = f.next();
			if(size.equals("twin"))
			{
				w=3;h=6;
			}
			else if(size.equals("full"))
			{
				w=4;h=6;
			}
			else if(size.equals("queen"))
			{
				w=5;h=7;
			}
			else if(size.equals("king"))
			{
				w=7;h=7;
			}
			char[][] bed = new char[h][w];
			for(int i=0;i<bed.length;i++)
				Arrays.fill(bed[i],'.');
			int x=f.nextInt()-1;
			int y=f.nextInt()-1;
			int n = f.nextInt();
			breed(bed,x,y,n);
			for(char[]b:bed)
			{
				for(char a:b)
					out.print(a);
				out.println();
			}
			out.println();

		}
	}
	static void breed(char [][]b,int x,int y,int n)
	{
		if(n>0&&x>=0&&x<b.length&&y>=0&&y<b[0].length)
		{
			b[x][y]='.';
			n--;
			if(x-1>=0)
			{
				b[x-1][y]='x';
				breed(b,x-1,y,n);
			}
			if(x+1<b.length)
			{
				b[x+1][y]='x';
				breed(b,x+1,y,n);
			}
			if(y-1>=0)
			{
				b[x][y-1]='x';
				breed(b,x,y-1,n);
			}
			if(y+1<b[0].length)
			{
				b[x][y+1]='x';
				breed(b,x,y+1,n);
			}
		}
	}
	public static void main(String[] args)throws Exception
	{
		bedbugs a=new bedbugs();
		a.run();
	}
}