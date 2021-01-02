//Owen - Punch and Judy - 
//Solution 

import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class punch
{
	static Scanner kb;
	static int num(String hex)
	{
		String hx="";
		for(int x=hex.length()-1;x>=0;x--)
		{
			String h=Integer.toBinaryString(Integer.parseInt(hex.substring(x,x+1),16));
			hx+="0000".substring(h.length())+h;
		}
//		StringBuilder sb = new StringBuilder(hx);
//		sb.reverse();
		return hx.substring(2).indexOf("1");
	}
	static String let(String hex)
	{
		String hx="";
		for(int x=hex.length()-1;x>=0;x--)
		{
			String h=Integer.toBinaryString(Integer.parseInt(hex.substring(x,x+1),16));
			hx+="0000".substring(h.length())+h;
		}
		StringBuilder sb = new StringBuilder(hx);
		sb.reverse();
		return new String(sb);
	}

	public static void main(String [] args) throws IOException

	{
		Scanner f = new Scanner(new File("punch.dat"));
		while(f.hasNext())
		{
			args = f.nextLine().split(" ");
			for(int x=0;x<3;x++)
			{
//				out.println(args[x]);
				int b = num(args[x]);
//				b = "000000000000".substring(b.length())+b;
//				StringBuilder s = new StringBuilder(b);
				
//				out.print(b);
				out.print(b>=0?b:"*");
			}
			out.print(" ");
			char[]lt=new char[6];
			Arrays.fill(lt,' ');
			for(int x=3;x<args.length;x++)
			{
				String z = let(args[x]);
//				out.println(z);
				for(int y=0;y<6;y++)
					if(z.charAt(y)=='1')
						if(lt[y]==' ')
							lt[y]=(char)(65+x-3);
						else
							lt[y]='*';
			}
			String word = new String(lt);
			out.println(word.charAt(0)+". "+word.substring(1));
		}
		
	}
}
/*
Judges input data:
100 002 010 200 100 400 010 800 000
800 020 001 800 000 A10 100 220 400
400 080 008 510 A00 000 000 000 000
200 001 040 200 400 100 800 810 000
000 100 400 210 900 000 420 000 000

Expected output:
905 B. ACED
641 D. *F*CE
72* A. BABA
813 C. AB*E
*97 B. ADBAD
*/


 