
import java.io.*;
import java.util.*;

public class Crops {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("crops.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            System.out.print("DATA SET " + i + " ");
            int numCrops = s.nextInt();
            s.nextLine();
            double max = -1;
            String best = "";
            for(int j = 0; j < numCrops; j++) {
                String crop = s.nextLine().trim();
                int hours = s.nextInt();
                int minutes = s.nextInt();
                int priceFor10 = s.nextInt();
                s.nextLine();
                minutes += hours * 60;
                double goldPerMinutePerPlot = 1.0 * priceFor10 / minutes / 5; // 10 units requires 5 plots
                goldPerMinutePerPlot = ((int) (goldPerMinutePerPlot * 100)) / 100.0;
                if(goldPerMinutePerPlot > max) {
                    max = goldPerMinutePerPlot;
                    best = crop;
                }
            }
            System.out.print(best + " ");
            System.out.printf("%4.2f", max);
            System.out.println();
        }
        s.close();
    }
    
 
}
