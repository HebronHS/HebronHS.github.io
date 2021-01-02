//Owen - Knapsack Problem - 
//Solution based on YouTube video by Mindez - http://www.youtube.com/watch?v=EH6h7WA7sDw

import static java.lang.System.*;
import java.io.*;
import java.util.*;

class Item 
{
	int value, weight,id;
			
	Item(int v,int w,int n)
	{
		value = v;
		weight = w;
		id = n+1;
	}
	public String toString()
	{
		return String.format("Item #%d - v=%d:w=%d ",id,value,weight);
	}
}
public class knapsack
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("knapsack.dat"));
		int N = f.nextInt();		//number of data sets
		while(N-->0)
		{
		int k =  f.nextInt();		//knapsack total weight
		int n = f.nextInt();		//number of items
		ArrayList<Item> list = new ArrayList<Item>();
		for(int x = 0;x<n;x++)
			list.add(new Item(f.nextInt(),f.nextInt(),x));
		//		out.println(list); - debugging statement
		int[][]Value = new int[n+1][k+1];	//create matrix of size #items+1 by total knapsack weight+1
		int[][]Keep = new int[n+1][k+1];	//create matrix of size #items+1 by total knapsack weight+1
		Scanner kb = new Scanner(in);
		//traverse matrix and build Value array, updating the values and marking the Keep array as you go.
		for(int r = 1;r<Value.length;r++)
			for(int c = 1;c<Value[0].length;c++)
			{
				if(list.get(r-1).weight > c) //if weight of item is greater than current knapsack 
											 //"subsize" capacity (same as column number)...
				{
					Value[r][c]=0;			//assign zero to both Value element
					Keep[r][c]=0;			//and Keep element
				}
				else
				if(list.get(r-1).weight==c&&list.get(r-1).value<Value[r-1][c])//if weight of item is equal to current 
							//knapsack "subsize" capacity, but value of previous "subsize" is greater
				{
					Value[r][c]=Value[r-1][c]; //put value of previous row item in array
					Keep[r][c]=1;			   //set keep value to 0
				}
				else
				if(list.get(r-1).weight==c)//if weight of item is equal to current knapsack "subsize" capacity
											//and value is equal or better than previous "subsize" value
				{
					Value[r][c]=list.get(r-1).value; //put value of item in array
					Keep[r][c]=1;					 //set keep value to 1
				}
				else
				if(list.get(r-1).value+Value[r-1][c-list.get(r-1).weight]>Value[r-1][c]) //if combined value of current item PLUS 
											//value in remaining knapsack capacity is greater than value in previous row
				{
					Value[r][c] = list.get(r-1).value+Value[r-1][c-list.get(r-1).weight];//put combined value in current Value location
					Keep[r][c]=1;					//set keep value to 1
				}
				else //use weight of current subsize in previous row
				{
					Value[r][c] = Value[r-1][c];//put previous "subsize" value in current Value location
					Keep[r][c]=0;					//set keep value to 0
				}
			}

//			output value and keep arrays for debugging purposes
/*			for(int r=0;r<Value.length;r++)
			{
				for(int c = 1;c<Value[0].length;c++)
					out.print(Value[r][c]+":"+Keep[r][c]+" ");
				out.println();
				out.println();
			}
*/
			//Process the Keep array
			ArrayList<Item> keep = new ArrayList<Item>();
			int w = k;
			int I = list.size();
			int tw = 0;//total weight kept
			int tv = 0;//total value kept
			for(int x = I;x>0;x--)
				if(Keep[x][w]==1 && w>0)
				{
					keep.add(0,list.get(x-1));
					w-=list.get(x-1).weight;
					tw += list.get(x-1).weight;
					tv += list.get(x-1).value;
//					out.println(keep);
				}
			out.println("knapsack capacity = "+k);
			out.println("total weight = "+tw);
			out.println("total value = "+tv);
			for(Item x:keep)
				out.println(x);
			out.println();
		}
			
	}	
}
/*Judges data
4
5
3
5 3
3 2
4 1
6
5
1 5
6 4
4 3
7 2
3 1
10
6
9 2
4 5
7 3
6 7
2 1
5 4
100
20
1 1000
49 25
14 19
73 61
9 23
52 11
7 54
14 14
7 2
16 4
88 42
82 23
5 33
10 43
15 53
20 88
25 73
30 83
35 93
40 103
*/
/*Judges output
knapsack capacity = 5
total weight = 4
total value = 9
Item #1 - v=5:w=3
Item #3 - v=4:w=1

knapsack capacity = 6
total weight = 6
total value = 14
Item #3 - v=4:w=3
Item #4 - v=7:w=2
Item #5 - v=3:w=1

knapsack capacity = 10
total weight = 10
total value = 20
Item #1 - v=9:w=2
Item #2 - v=4:w=5
Item #3 - v=7:w=3

knapsack capacity = 100
total weight = 99
total value = 223
Item # 4 - v=73:w=61
Item # 6 - v=52:w=11
Item #10 - v=16:w=4
Item #12 - v=82:w=23

*/
