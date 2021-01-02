//Owen - Hexiral - 
//Solution 

import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class hexiral
{
	static char g[][];
	static Scanner kb;
	static void spiral(String s)
	{
		g=new char[11][16];
		for(int x = 0;x<11;x++)
			Arrays.fill(g[x],' ');
		int tr=0,br=10,lc=5,rc=10,r=tr,c=lc,i=0,loop=0;
		while(g[r][c]==' ')	
		{
			//across the top
			for(;c<rc;c++)
			{
				if(g[r][c]!=' ') break;
				g[r][c]=s.charAt(i++);
				if(i==s.length())
					i=0;
			}
			//top right slant
			for(;c<15-loop;c++,r++)
			{
				if(g[r][c]!=' ') break;
				g[r][c]=s.charAt(i++);
				if(i==s.length())
					i=0;
			}
			//bottom right slant
			for(;r<br;c--,r++)
			{
				if(g[r][c]!=' ') break;
				g[r][c]=s.charAt(i++);
				if(i==s.length())
					i=0;
			}
			//across the bottom 
			for(;c>lc;c--)
			{
				if(g[r][c]!=' ') break;
				g[r][c]=s.charAt(i++);
				if(i==s.length())
					i=0;
			}
			//bottom left slant
			for(;c>0+loop;r--,c--)
			{
				if(g[r][c]!=' ') break;
				g[r][c]=s.charAt(i++);
				if(i==s.length())
					i=0;
			}
			//top left slant
			for(;r>tr;c++,r--)
			{
				if(g[r][c]!=' ') break;
				g[r][c]=s.charAt(i++);
				if(i==s.length())
					i=0;
			}
			tr++;
			br--;
			loop++;
			r=tr;
			c=lc;
//			spiralOut();
//			kb.nextLine();
		}
//		g[r][c]='*';
		
	}
	static void spiralOut()
	{
    	for(int r=0;r<g.length;r++)
		{
			for(int c=0;c<g[r].length;c++)
				out.print(g[r][c]);
			out.println();
		}

	}
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("hexiral.dat"));
		kb=new Scanner(in);
		int n = f.nextInt();
		while(n-->0)
		{
			spiral(f.next());
			spiralOut();
			out.println();
		}
	}
}
/*
     dogdog
    gdogdogd
   oogdogdodo
  ddgdogdoggog
 ggogdogdogddgd
oodoogdogdodoodo
 ddgddgodgoggog
  ggogodgoddgd
   oodgodgodo
    ddgodgog
     godgod

     zebraz
    azebraze
   rzebrazeeb
  babrazebrbbr
 erezebrazearra
zbzaazebrazbzaaz
 aearrbezarezze
  rzrbezarbeeb
   babezarbbr
    erbezara
     zarbez

     elepha
    antelepn
   htelephaht
  pnantelepnae
 eahtelephahtnl
lhpnantelepnaete
 epeahpeletnlep
  telhpeletelh
   nletnahpea
    aetnahpn
     hpelet

*/ 