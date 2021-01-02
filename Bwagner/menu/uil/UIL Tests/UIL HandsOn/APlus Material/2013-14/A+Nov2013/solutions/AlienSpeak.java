import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Dynamic Programming Solution to Longest Common Subsequence

public class AlienSpeak {
	public static void main(String [] args) throws FileNotFoundException { 
		Scanner f = new Scanner(new File("alienspeak.dat"));
		int N = f.nextInt(); f.nextLine();
		while(N-- > 0) {
			String a = f.next();
			String b = f.next();
			int lcs = computeLCS(a.toCharArray(), b.toCharArray());
			System.out.println(lcs);
		}
		f.close();
	}
	
	/*
	 * Each element of C[i][j] holds a solution to a subproblem defined by the longest common subsequence
	 * witin the first i characters of X and the first j characters Y. As C continues to get filled out,
	 * C contains solutions to the first 0 - i-1 characters of X and 0 - j characters of Y, so when another
	 * common character is found in sequence, one can be added to the current position.
	 */
	public static int computeLCS(char [] X, char [] Y) {
	    int [][] C  = new int[X.length+1][Y.length+1];
	    
	    for(int i = 1; i<=X.length; i++) {
	    	for(int j = 1; j<=Y.length; j++) {
	    		if(X[i-1] == Y[j-1]) {
	    			C[i][j] = C[i-1][j-1] + 1;
	    		}
	    		else {
	    			C[i][j] = Math.max(C[i][j-1], C[i-1][j]);
	    		}
	    	}
	    }
	    return C[X.length][Y.length];
	}
}
/*
Judge's data:
10
lagqandr lxxqan
arbbeez axrbez
applesnnmbbareyubbnm applezzdeqqsareyum
hairrfgfghryjinerm rqzzzxvjkhaloiryqzzjimnneerr
aaabbbababbaabb aaaaaaaaa
aaaaaaa aabbabdkekfkskekgjejzlejelkfnbklksiedkglkjklsaaa
ababababab aabbaabbaabb
aaaaabbbbb a
b aaaaa
aaggaagg gaga

Expected output:
4
5
12
10
7
6
8
1
0
3
*/