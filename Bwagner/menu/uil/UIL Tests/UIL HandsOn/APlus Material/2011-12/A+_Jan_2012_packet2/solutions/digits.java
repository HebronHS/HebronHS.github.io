import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class digits {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("digits.in"));
		int n = sc.nextInt();
		while(n-- > 0){
			int k = sc.nextInt();
			System.out.println(getSmallest(k));
		}
	}
	static int getSmallest(int N)
	{
	  int c1,i,j;
	  c1=0;
	  int[] arr = new int[13];
	  while (N>0)
	  {
	    arr[c1++]=N%10;
	    N/=10;
	  }
	  if (c1==0) arr[c1++]=0;
	  for (i=0;i<=9;i++)
	  {
	    if (i!=arr[c1-1]) break;
	  }
	  for (j=c1-2;j>=0;j--) i=i*10+arr[j];
	  return i;
	}
}
