

import java.io.*;
import java.util.*;

public class Perfect {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("perfect.dat"));
        int numSets = s.nextInt();

        for(int i = 1; i <= numSets; i++){
            double[][] distances = new double[s.nextInt()][s.nextInt()];
            s.nextLine();
            String[] temp = s.nextLine().trim().split("\\s+");
            assert temp.length % 2 == 0 : "NOT EVEN NUMBER OF COORDINATES";
            int[] coordinates = new int[temp.length];
            for(int j = 0; j < temp.length; j++)
                coordinates[j] = Integer.parseInt(temp[j]);
            
            calcDistances(distances, coordinates);
            // showDistances(distances);
            showMin(distances);
            
        }
        s.close();
    }

    private static void showDistances(double[][] distances) {
        for(int r = 0; r < distances.length; r++) {
            for(int c = 0; c < distances[0].length; c++) {
                System.out.print(distances[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void showMin(double[][] distances) {
        double minD = Double.MAX_VALUE;
        int rr = -1;
        int cr = -1;
        double diff = 0;
        for(int r = 0; r < distances.length; r++)
            for(int c = 0; c < distances[0].length; c++)
                if(distances[r][c] < minD) {
                    diff = distances[r][c] - minD;
                    minD = distances[r][c];
                    rr = r;
                    cr = c;
                }
        // System.out.println(diff);
        System.out.println(rr + " " + cr);
    }

    private static void calcDistances(double[][] distances, int[] coordinates) {
        for(int r = 0; r < distances.length; r++)
            for(int c = 0; c < distances[0].length; c++) 
                for(int i = 0; i < coordinates.length; i += 2) {
                    
                    int rs = coordinates[i];
                    
                    assert 0 <= rs && rs < distances.length : "ROW OUT OF BOUNDS. rows = " + distances.length + " row data: " + rs;
                    int cs = coordinates[i + 1];
                    assert 0 <= cs && cs < distances[0].length : "COL OUT OF BOUNDS. cols = " + distances[0].length + " col data: " + cs;
                    // System.out.println(distances[rs][cs]);
                    double tempD = Math.pow(r - rs, 2);
                    tempD += Math.pow(c - cs, 2);
                    distances[r][c] += Math.sqrt(tempD);
                }
    }
    
 
}
