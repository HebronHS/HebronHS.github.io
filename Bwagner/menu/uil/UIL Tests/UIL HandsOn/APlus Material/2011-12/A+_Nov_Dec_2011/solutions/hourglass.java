//Solution - HeadLine News Packet - John Owen - 2011
//Hour Glass

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class hourglass
{
	public void run()throws Exception
	{
		Scanner f=new Scanner(new File("hourglass.dat"));
		String s = f.nextLine();
		Scanner chop = new Scanner(s);
		char[][]g=null;
		int n;
		while(chop.hasNext())
		{
			n = chop.nextInt();
			g=new char[n][n];
			int layers = n/5;
			for(int r=0;r<n;r++)
				for(int c = r;c<n-r;c++)
					if(r==0||c==r||c==n-r-1)
						g[r][c]=g[n-r-1][c]='*';
			for(int r=n/3;r<n/3+layers;r++)
				for(int c = r+1;c<n-r-1;c++)
					g[r][c]='*';
			for(int r=n-layers-1;r<n-1;r++)
				for(int c = n-r;c<r;c++)
					g[r][c]='*';

		for(char[]c:g)
		{
			for(char a:c)
				out.print(a);
			out.println();
		}
		out.println();
		}

	}
	public static void main(String[] args)throws Exception
	{
		hourglass a=new hourglass();
		a.run();
	}
}