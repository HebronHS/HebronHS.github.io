import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class excel {
	public static void main(String [] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("excel.in"));
		int n = sc.nextInt();
		while(n-- > 0){
			long col = sc.nextInt();
			long pw = 26;
			int len = 1;
			long[] p = new long[30];
			p[1] = 26;
			p[0] = 1;
			for(int i=2;i<30;i++)p[i]=p[i-1]*26;
			int sum = 26;
			while(col > sum){
				len++;
				pw *= 26;
				sum += pw;
			}
			String z = "";
			long k = 0;
			for(int j = 1; j <= len-1; j++) k+= p[j];
			long smallest = k;
			col = col - smallest - 1;
			
			while(len > 0){
			//	System.out.println(col+" "+len);
				long div = col / p[len - 1];
				long rem = col % p[len - 1];
				z+=((char)('A'+div));
				
				col = col - div * p[len-1];
		//		System.out.println("new col " +  col);
				len--;
			}
			System.out.println(z);
		
		}
	}
}
