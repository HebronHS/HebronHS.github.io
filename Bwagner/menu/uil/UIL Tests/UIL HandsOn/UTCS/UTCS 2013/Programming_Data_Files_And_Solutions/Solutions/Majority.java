package _UTCS_13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Majority {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("UTCS_13\\judges\\majority.dat"));
		int runs = scan.nextInt();
		scan.nextLine();

		for (int i = 0; i < runs; i++) {
			String votes = scan.nextLine();
			// printMajority(votes);
			char c = possibleMajority(votes);
			System.out.println(verifyMajority(votes, c));
		}
	}
	
	// alternate solution using map
	public static void printMajority(String votes) {
	    Map<Character, Integer> voteCount = new HashMap<Character, Integer>();
	    for(int i = 0; i < votes.length(); i++) {
	        char ch = votes.charAt(i);
	        if(voteCount.containsKey(ch))
	            voteCount.put(ch, voteCount.get(ch) + 1);
	        else
	            voteCount.put(ch, 1);
	    }
	    int max = -1;
	    char maxVote = ' ';
	    for(char candidate : voteCount.keySet()) 
	        if(voteCount.get(candidate) > max) {
	            max = voteCount.get(candidate) ;
	            maxVote = candidate;
	        }
	    // System.out.println(voteCount);
	    if(1.0 * max / votes.length() > 0.5)
	        System.out.println(maxVote);
	    else
	        System.out.println("NO MAJORITY");
	}

	public static char possibleMajority(String votes) {
		char majority = votes.charAt(0);
		int k = 1;

		for (int i = 1; i < votes.length(); i++) {
			if (k == 0)
				majority = votes.charAt(i);
			if (votes.charAt(i) == majority)
				k++;
			else k--;
		}
		return majority;
	}

	public static String verifyMajority(String votes, char c) {
		int instances = 0;
		for (char b : votes.toCharArray())
			if (b == c)
				instances++;
		double percentage = (instances * 1.0) / votes.length();
		if (percentage > .5)
			return "" + c;
		else return "NO MAJORITY";
	}
}
