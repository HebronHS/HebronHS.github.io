import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class anni {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("anni.in"));
		int inp = sc.nextInt();
		while(inp-- > 0){
			int n = sc.nextInt();			
			System.out.println(n%2==0 ? calc(n):0);
		}
	}
	public static long calc(int n)
	{
		if(n==0) return 1;
		long ways = 0;
		for(int i=1;i<n;i+=2){
			ways += calc(i-1) * calc(n-i-1);
		}
		return ways;
	}
}
