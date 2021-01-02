import java.io.*;
import java.util.*;

class Quest
{
	public static Cell[][]map;
	public static Cell grail;
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("quest.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-->0)
		{
			//declaration
			map = new Cell[10][10];
			char [][] temp_map = new char[10][10];
			Cell rabbit = null;
			Cell arthur = null;
			grail = null;
			
			//finish initialzing map to avoid null pointers
			//read in the data
			for(int r = 0; r<10; r++)
			{
				String line = f.nextLine();
				for(int c = 0; c<10; c++)
				{
					map[r][c] = new Cell();
					temp_map[r][c] = line.charAt(c);
				}
			}
			
			//place data into data structure
			for(int r = 0; r<10; r++)
			{
				for(int c = 0; c<10; c++)
				{
					if(r - 1 >=0)
						map[r][c].up = map[r-1][c];
					if(r + 1 < 10)
						map[r][c].down = map[r+1][c];
					if(c - 1 >=0)
						map[r][c].left = map[r][c-1];
					if(c+1<10)
						map[r][c].right = map[r][c+1];
						
					map[r][c].value = temp_map[r][c];
					
					if(temp_map[r][c] == 'K')
						rabbit = map[r][c];
					if(temp_map[r][c] == 'A')
						arthur = map[r][c];
					if(temp_map[r][c] == 'H')
						grail = map[r][c];
				}
			}
			
			//void the spaces arthur can walk, and allow walkables spaces to be walked
			if(rabbit!=null)
			{
				if(rabbit.up != null)
					rabbit.up.value = '#';
				if(rabbit.down != null)
					rabbit.down.value = '#';
				if(rabbit.right != null)
					rabbit.right.value = '#';
				if(rabbit.left != null)
					rabbit.left.value = '#';
				rabbit.value = '#';
			}
			grail.value = '.';
			arthur.value = '.';
			
			//searching algorithm
			arthur.count = 0;
			while(grail.count == 1000)
			{
				for(int r = 0; r<10; r++)
				{
					for(int c = 0; c<10; c++)
						if(map[r][c].value == '.')
							Cell.search(map[r][c]);
				}
			}
			
			//backtrace shortest path, marking it with O's
			Cell.backtrace(grail);
			
			//change arthur and grail back
			arthur.value = 'A';
			grail.value = 'H';
			
			//print orginal map with changes
			for(int r = 0; r<10; r++)
			{
				for(int c = 0; c<10; c++)
				{
					if(map[r][c].value == 'O')	
						System.out.print(map[r][c].value);
					else
						System.out.print(temp_map[r][c]);
				}
				System.out.println();
			}
			System.out.println();
	
			//gets the dash between segments
			if(N>0)
				f.nextLine();
		}
	}
}
class Cell
{
	//made public for readability without accessor methods
	public Cell up;
	public Cell down;
	public Cell right;
	public Cell left;
	public char value;
	public int count=1000;
	public Cell()
	{}
	public static void search(Cell s)
	{
		if(s.up!=null&&s.up.value=='.'&&s.count+2<s.up.count)
			s.up.count = s.count+1;
		if(s.down!=null&&s.down.value=='.'&&s.count+2<s.down.count)
			s.down.count = s.count+1;
		if(s.right!=null&&s.right.value=='.'&&s.count+2<s.right.count)
			s.right.count = s.count+1;
		if(s.left!=null&&s.left.value=='.'&&s.count+2<s.left.count)
			s.left.count = s.count+1;
	}
	public static void backtrace(Cell s)
	{
		if(s == null)
			return;
		s.value = 'O';
		if(s.up!=null && s.up.count +1 == s.count)
		{
			backtrace(s.up);
			return;
		}
			
		if(s.down!=null && s.down.count +1 == s.count)
		{
			backtrace(s.down);
			return;
		}
			
		if(s.left!=null && s.left.count +1 == s.count)
		{
			backtrace(s.left);
			return;
		}
			
		if(s.right!=null && s.right.count +1 == s.count)
		{
			backtrace(s.right);
			return;
		}
			
	}
}