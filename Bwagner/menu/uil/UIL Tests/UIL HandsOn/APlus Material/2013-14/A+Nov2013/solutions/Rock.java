import java.io.*;
import java.util.*;
import static java.lang.System.*;

//Rock Paper Scissors - Owen Solution - Brute Force if else

public class Rock
{ 
	public static void main(String [] args) throws FileNotFoundException 
	{
		Scanner f = new Scanner(new File("rock.dat"));
		int n = f.nextInt();
		f.nextLine();
		while(n-->0)
		{
			String s = f.nextLine();
			out.print(s+" ");
			if(s.equals("PAPER ROCK")||s.equals("SCISSORS PAPER")||s.equals("ROCK SCISSORS"))
				out.println("YOU WIN");
			else
			if(s.equals("PAPER PAPER")||s.equals("SCISSORS SCISSORS")||s.equals("ROCK ROCK"))
				out.println("TIE");
			else
				out.println("YOU LOSE");
		}
				
	}
}

/*
Judge's data
9
ROCK SCISSORS
ROCK PAPER
SCISSORS ROCK
ROCK ROCK
PAPER SCISSORS
SCISSORS PAPER
PAPER PAPER
SCISSORS SCISSORS
PAPER ROCK


Expected output:
ROCK SCISSORS YOU WIN
ROCK PAPER YOU LOSE
SCISSORS ROCK YOU LOSE
ROCK ROCK TIE
PAPER SCISSORS YOU LOSE
SCISSORS PAPER YOU WIN
PAPER PAPER TIE
SCISSORS SCISSORS TIE
PAPER ROCK YOU WIN
*/

