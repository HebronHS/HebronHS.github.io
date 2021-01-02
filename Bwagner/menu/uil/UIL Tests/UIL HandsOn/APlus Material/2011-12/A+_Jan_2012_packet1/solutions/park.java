import java.util.*;
import java.io.*;

public class park {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader((new FileReader(new File("park.in"))));
        int cs = Integer.parseInt(in.readLine());
        while (cs-- > 0) {
            String xx = in.readLine();
            String[] xxa = xx.split(" ");
            int n = Integer.parseInt(xxa[0]);
            int m = Integer.parseInt(xxa[1]);

            if (n == 0) break;

            HashMap<Integer, TreeSet<Integer>> tx = new HashMap<Integer, TreeSet<Integer>>();
            HashMap<Integer, TreeSet<Integer>> ty = new HashMap<Integer, TreeSet<Integer>>();
            TreeSet<Integer> vert = new TreeSet<Integer>(), horiz = new TreeSet<Integer>();
            
            int[] px = new int[n];
            int[] py = new int[n];
            
            HashSet<Long> vis = new HashSet<Long>();

            for (int i = 0; i < n; i++) {
                xx = in.readLine();
                StringTokenizer st = new StringTokenizer(xx);
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                px[i] = x;
                py[i] = y;
                if (tx.get(x) == null) {
                    tx.put(x, new TreeSet<Integer>());
                }
                if (ty.get(y) == null) {
                    ty.put(y, new TreeSet<Integer>());
                }
                tx.get(x).add(y);
                ty.get(y).add(x);
            }

            for (int i = 0; i < m; i++) {
                StringTokenizer line = new StringTokenizer(in.readLine(), "=");
                char xy = line.nextToken().charAt(0);
                int li = Integer.parseInt(line.nextToken());

                if (xy == 'x') {
                   vert.add(li);
                } else {
                   horiz.add(li);
                }
            }
            
            for(int i = 0; i < n; i++){
            	int x = px[i], y = py[i];
            	Integer left_vert = vert.floor(x);
            	Integer right_vert = vert.ceiling(x);
            	Integer left_pt = ty.get(y).floor(x-1);
            	Integer right_pt = ty.get(y).ceiling(x+1);
            	Integer bot_horiz = horiz.floor(y);
            	Integer top_horiz = horiz.ceiling(y);
            	Integer bot_pt = tx.get(x).floor(y-1);
            	Integer top_pt = tx.get(x).ceiling(y+1);
            	if(left_vert != null && (left_pt == null || left_vert.compareTo(left_pt) > 0)) vis.add(((long) x) << 32 | y);
            	if(right_vert != null && (right_pt == null || right_pt.compareTo(right_vert) > 0)) vis.add(((long) x) << 32 | y);
            	if(bot_horiz != null && (bot_pt == null || bot_horiz.compareTo(bot_pt) > 0)) vis.add(((long) x) << 32 | y);
            	if(top_horiz != null && (top_pt == null || top_pt.compareTo(top_horiz) > 0)) vis.add(((long) x) << 32 | y);
            }
           
            System.out.println(vis.size());
        }
    }
}
