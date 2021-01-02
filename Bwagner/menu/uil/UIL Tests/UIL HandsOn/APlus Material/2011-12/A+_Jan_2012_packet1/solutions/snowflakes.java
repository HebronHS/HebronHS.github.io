import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class snowflakes{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("snowflakes.in"));
		int cs = sc.nextInt();
		while(cs-- > 0){
			int n = sc.nextInt();
			char[][] x = new char[n][n];
			boolean grace = true;
			boolean beau = true;
			for(int i = 0 ; i < n ; i ++)x[i]=sc.next().toCharArray();
			for(int i = 0; i < n; i++){
				for(int k =0; k < n/2; k++){
					if(x[i][k] != x[i][n-k-1]){
						grace = false;
					}
					if(x[k][i] != x[n-k-1][i]){
						beau = false;
					}
				}
			}
			if(beau && grace)System.out.println("Magnificent");
			else if(beau)System.out.println("Beautiful");
			else if(grace)System.out.println("Graceful");
			else System.out.println("Useless");
		}
	}
}
