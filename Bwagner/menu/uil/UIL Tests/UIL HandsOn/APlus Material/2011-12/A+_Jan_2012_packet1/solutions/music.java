import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;


public class music {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("music.in"));
		int cs = sc.nextInt();
		while(cs-- > 0){
			int n = sc.nextInt(), m = sc.nextInt(), c = sc.nextInt();
			int[] x = new int[n];
			for(int i = 0 ; i < n ; i ++) x[i] = sc.nextInt();
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			StringBuffer res = new StringBuffer();
			if(m > n){
				System.out.println(0);
				continue;
			}
			for(int ii = 0; ii < m; ii++){
				insert(map, x[ii]);
			}
			if(map.lastKey() - map.firstKey() <= c){
				res.append("1");
			}
			for(int i = 1; i <= n - m; i++){
				insert(map, x[i+m-1]);
				delete(map, x[i-1]);
				if(map.lastKey() - map.firstKey() <= c){
					res.append(i+1);
				}
			}
			System.out.println(res.length());
		}
	}
	public static void insert(TreeMap<Integer, Integer> map, int val){
		if(map.get(val)==null){
			map.put(val, 1);
		}else{
			map.put(val, 1 + map.get(val));
		}
	}
	public static void delete(TreeMap<Integer, Integer> map, int val){
			map.put(val, map.get(val) - 1);
			if(map.get(val)==0) map.remove(val);
	}
}
