package _UTCS_13;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Tunnels {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_13\\judges\\tunnels.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            Graph g = new Graph(s.nextLine().trim());
            System.out.println(g.parts());
        }
        s.close();
    }
    
    private static final class Graph {
        boolean[][] adjMatrix;
        
        public Graph(String s) {
            Map<String, Integer> rows = new HashMap<String, Integer>();
            // find the end of the list
            int indexEnd = s.indexOf("},");
            String list = indexEnd >= 0 ? s.substring(1, indexEnd) : s;
            String pairs = indexEnd > 0 ? s.substring(indexEnd + 2) : "";

            String[] buildings = list.trim().split(",");
            int bID = 0;
            for(String b : buildings) {
                assert !rows.containsKey(b);
                rows.put(b, bID++);
            }
            
            adjMatrix = new boolean[rows.size()][rows.size()];
            
            pairs = pairs.replace("}", "").replace("{", "");
            String[] buildPairs = pairs.trim().split(",");
            // System.out.println(Arrays.toString(buildPairs));
            assert buildPairs.length % 2 == 0 || (buildPairs.length == 1 && buildPairs[0].equals("")): "number of buildings in pairs not even";
            
            if(buildPairs.length == 1)
                buildPairs = new String[0];
            
            for(int i = 0; i < buildPairs.length; i += 2) {
                String b1 = buildPairs[i];
                String b2 = buildPairs[i + 1];
                assert rows.containsKey(b1) && rows.containsKey(b2) : "building in pairs, not in list!!!";
                adjMatrix[rows.get(b1)][rows.get(b2)] = true;
                adjMatrix[rows.get(b2)][rows.get(b1)] = true;
            }
        }
        
        public int parts() {
            int count = 0;
            boolean[] used = new boolean[adjMatrix.length];
            for(int i = 0; i < used.length; i++) {
                if(!used[i]) {
                    count++;
                    used[i] = true;
                    Queue<Integer> q = new LinkedList<Integer>();
                    q.add(i);
                    while(!q.isEmpty()) {
                        int row = q.remove();
                        for(int col = 0; col < adjMatrix[0].length; col++) {
                            if(adjMatrix[row][col] && !used[col]) {
                                q.add(col);
                                used[col] = true;
                            }
                        }
                    }
                }
            }
            return count;
        }
    }
}
