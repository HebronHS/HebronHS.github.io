

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Gas {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("gas.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            int stations = s.nextInt();
            double gallons = s.nextDouble();
            double mpg = s.nextDouble();
            double wearPerMile = s.nextDouble();
            
            double minCost = Double.MAX_VALUE;
            int index = -1;
            
            for(int j = 1; j <= stations; j++) {
                
                double distance = s.nextDouble() * 2;
                double price = s.nextDouble();
                double cost = price * gallons + distance / mpg * price;
                cost += distance * wearPerMile;
                if(cost < minCost) {
                    minCost = cost;
                    index = j;
                }
                // System.out.println(j + " " + cost);    
            }
            // System.out.println(minCost);
            System.out.print(i + ": " + index + " ");
            System.out.printf("%.2f", minCost);
            System.out.println();
        }
        s.close();
    }
    
 
}

