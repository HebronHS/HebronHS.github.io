//Sample Solution to MazeMap
import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class MazeMap
{
	public static void main(String [] args) throws IOException
	{
		Scanner file = new Scanner(new File("mazemap.dat"));
		int n = file.nextInt();
		while(n-->0)
		{
			int N = file.nextInt();
			String one = file.next();
			String two = file.next();
			if(N<=5)
			{
				for(int x = 0;x<N;x++)
				{
					int v = Integer.parseInt(one.substring(x,x+1),16);
					String t = Integer.toBinaryString(v);
					if(t.length()<4)
						t = "0000".substring(t.length())+t;
					t=t.substring(0,N-1);
					out.print(t+" ");
				}
				out.println();
				for(int x = 0;x<N;x++)
				{
					int v = Integer.parseInt(two.substring(x,x+1),16);
					String t = Integer.toBinaryString(v);
					if(t.length()<4)
						t = "0000".substring(t.length())+t;
					t=t.substring(0,N-1);
					out.print(t+" ");
				}
				out.println();
			}
			else
			{
				for(int x = 0;x<N*2;x+=2)
				{
					int v = Integer.parseInt(one.substring(x,x+2),16);
					
					String t = Integer.toBinaryString(v);
					if(t.length()<8)
						t = "00000000".substring(t.length())+t;
					t=t.substring(0,N-1);
					out.print(t+" ");
				}
				out.println();
				for(int x = 0;x<N*2;x+=2)
				{
					int v = Integer.parseInt(two.substring(x,x+2),16);
					String t = Integer.toBinaryString(v);
					if(t.length()<8)
						t = "00000000".substring(t.length())+t;
					t=t.substring(0,N-1);
					out.print(t+" ");
				}
				out.println();
			}
			out.println();
		}
	}
}