import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class pal{
	static String s;
	static int[][] dp;
	static int n;
	static char[] c;
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("pal.in"));
		int cs = sc.nextInt();
		while(cs-- > 0){
			s = sc.next();
			c = s.toCharArray();
			n = s.length();
			dp = new int[n][n];
			for(int i = 0 ; i < n; i++)Arrays.fill(dp[i], -1);
			System.out.println(find(0, n-1));
		}
	}
	public static int find(int L, int R){
		if(L==R) return dp[L][R] = 1;
		if(L>R) return 0;
		if(dp[L][R] != -1) return dp[L][R];
		
		int res = -1;
		if(c[L] == c[R])
			res = Math.max(res, 2+find(L+1, R-1));
		res = Math.max(res, find(L+1, R));
		res = Math.max(res, find(L, R-1));
		return dp[L][R] = res;
	}
}
