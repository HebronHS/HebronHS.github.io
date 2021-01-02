import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class sun{
	static int best;
	static char[][] g;
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("sun.in"));
		int cs = sc.nextInt();
		while(cs-- > 0){
			int r = sc.nextInt(), c = sc.nextInt();
			sc.nextLine();
		    g = new char[r][c];
			int pr = -1, pc = -1;
			for(int i=0;i<r;i++){
				String s = sc.nextLine(); 
				for(int k=0;k<c;k++){
					g[i][k] = s.charAt(k);
					if(g[i][k] == 'P') {
						pr = i;
						pc = k;
					}
				}
			}
			best = 0;
			find(pr, pc, 0);
			System.out.println(best);
		}
	}
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void find(int r, int c, int s){
		best = Math.max(best, s);
		for(int d = 0 ; d < 4; d++){
			int nr = r + dy[d];
			int nc = c + dx[d];
			if(g[nr][nc] == '#') continue;
			g[nr][nc] = '#';
			find(nr, nc, d < 2 ? s - 1 : s + 1);
		}
	}
}
