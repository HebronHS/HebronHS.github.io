import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class ksort {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("ksort.in"));
		int inp = sc.nextInt();
		while(inp-- > 0){
			int k = sc.nextInt();
			String[] arr = sc.nextLine().trim().split(" ");
			int[] a = new int[arr.length];
			int[] b = new int[arr.length];
			for(int i=0;i<a.length;i++){
				a[i] = Integer.parseInt(arr[i]);
				b[i]=a[i];
			}
			Arrays.sort(b);
			boolean g=true;
			for(int i=0;i<b.length;i++){
				int dis = Arrays.binarySearch(b, a[i]);
				if(Math.abs(dis-i) > k) g = false;
			}
			System.out.println(g?"Yes":"No");
		}
	}
}
