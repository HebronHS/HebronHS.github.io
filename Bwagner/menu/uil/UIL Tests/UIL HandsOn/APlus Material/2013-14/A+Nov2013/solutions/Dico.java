import java.io.*;
import java.util.*;
import static java.lang.System.*;

//Dico - Owen Solution

public class Dico
{ 
	public static void main(String [] args) throws FileNotFoundException 
	{
		//set for win on first roll	
		Set<Integer> set1 = new TreeSet<Integer>();
		set1.add(7);
		set1.add(11);
		set1.add(15);
		set1.add(20);
		//set for loss on first roll
		Set<Integer> set2 = new TreeSet<Integer>();
		set2.add(2);
		set2.add(3);
		set2.add(10);
		set2.add(13);
		set2.add(19);
		//set for loss on subsequent rolls
		Set<Integer> set3 = new TreeSet<Integer>();
		set3.add(7);
		set3.add(11);
		set3.add(15);
		set3.add(10);

		Scanner f = new Scanner(new File("dico.dat"));
		int N = f.nextInt(); 
		f.nextLine();
		int roll = 0;
		while(N-- > 0) 
		{
			roll = f.nextInt();
			int first = roll;
			int x=1;
			if(set1.contains(first))//if first roll in winning set
			{
				out.println("WIN "+x);
				f.nextLine();//skip to next data line
			}
			else
			if(set2.contains(first))//if first roll in losing set
			{
				out.println("LOSS "+x);
				f.nextLine();//skip to next data line
			}
			else
			for(roll = f.nextInt(),x=2;roll != 0;x++,roll = f.nextInt())
			{
				if(set3.contains(roll))//if subsequent roll is in losing set
				{
					out.println("LOSS "+x);	
					f.nextLine();//skip to next data line
					break;//break out of the loop
				}
				else
				if(roll==first)//if current roll matches first roll
				{
					out.println("WIN "+x);
					f.nextLine();//skip to next data line
					break;//break out of the loop
				}
			}
			if(roll==0)//if reached end of game with no winner or loser
				out.println("NO RESULT "+(x-1));
		}
	}
}

/*
Judge's data
8
2 3 4 15 6 0
5 3 12 19 16 5 8 8 8 0
1 11 4 2 2 12 20 2 12 0
14 18 0
14 14 0
9 1 4 12 3 5 16 11 10 0
14 5 6 18 9 1 5 16 5 16 5 16 5 16 5 16 5 0
5 19 11 5 15 17 7 0

Expected output:
LOSS 1
WIN 6
LOSS 2
NO RESULT 2
WIN 2
LOSS 8
NO RESULT 17
LOSS 3

*/

