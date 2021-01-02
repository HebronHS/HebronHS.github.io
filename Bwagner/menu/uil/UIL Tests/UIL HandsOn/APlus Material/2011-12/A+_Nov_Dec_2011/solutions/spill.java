//Solution - HeadLine News Packet - John Owen - 2011
//Spill

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class spill
{
	static char [][]g;
	static boolean clean;
	static char dir;
	class Pos
	{
		int x,y;
		Pos(int xx,int yy)
		{
			x=xx;y=yy;
		}
	}
	static Pos nextPos(Pos p)
	{
		clean = true;
//		out.println("get next pos");
		if(dir=='^'&&p.x-1>=0&&g[p.x-1][p.y]=='*')//if north is clear..location exists and still dirty
		{
//			out.println("go north");
			p.x--;//go north
			g[p.x][p.y]='^';//mark new position with '^'
			if(p.y-1>=0&&g[p.x][p.y-1]=='*')//if left (west) is clear, change direction to west
			dir='<';clean = false;
		}
	else	if(dir=='<'&&p.y-1>=0&&g[p.x][p.y-1]=='*')//if west is clear..location exists and still dirty
		{
//			out.println("go west");
			p.y--;//go west
			g[p.x][p.y]='<';//mark new position with '<'
			if(p.x+1<g.length&&g[p.x+1][p.y]=='*')//if left (south) is clear, change direction to south
			dir='v';clean = false;
		}
	else	if(dir=='v'&&p.x+1<g.length&&g[p.x+1][p.y]=='*')//if west is clear..location exists and still dirty
		{
//			out.println("go south");
			p.x++;//go south
			g[p.x][p.y]='v';//mark new position with 'v'
			if(p.y+1<g.length&&g[p.x][p.y+1]=='*')//if left (east) is clear, change direction to east
			dir='>';clean = false;
		}
	else	if(dir=='>'&&p.y+1<g.length&&g[p.x][p.y+1]=='*')//if west is clear..location exists and still dirty
		{
//			out.println("go east");
			p.y++;//go east
			g[p.x][p.y]='>';//mark new position with '>'
			if(p.x-1>=0&&g[p.x-1][p.y]=='*')//if left (north) is clear, change direction to north
			dir='^';clean = false;
		}
		return p;
	}
	public void run()throws Exception
	{
		Scanner f=new Scanner(new File("spill.dat"));
		int n,x,y,px,py;//size of grid, starting x and y, current position of x and y
		int N = f.nextInt();
		while(N-->0)
		{
		n=f.nextInt();
		clean = false;
		x=f.nextInt()-1;
		y=f.nextInt()-1;
		Pos p=new Pos(x,y);
		g=new char[n][n];
		for(int r=0;r<n;r++)
			Arrays.fill(g[r],'*');
		g[x][y]='O';
		dir = '^';
		while(!clean)
			p = nextPos(p);
		g[p.x][p.y]='X';
		for(char[]c:g)
		{
			for(char d:c)
				out.print(d);
			out.println();
		}
		out.println();
		}
	}
	public static void main(String[] args)throws Exception
	{
		spill a=new spill();
		a.run();
	}
}