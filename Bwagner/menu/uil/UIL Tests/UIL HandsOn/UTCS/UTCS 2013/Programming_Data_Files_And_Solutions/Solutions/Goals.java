package _UTCS_13;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Goals {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_13\\judges\\goals.dat"));
        int numSets = s.nextInt();

        for(int i = 1; i <= numSets; i++) {
            int numRides = s.nextInt();
            s.nextLine();
            // System.out.println(numRides);
            String[] rides = {};
            if(numRides > 0)
                rides = s.nextLine().split("\\s+");
            assert rides.length == numRides;
            int goal1 = s.nextInt();
            int goal2 = s.nextInt();
            s.nextLine();
            // System.out.println(goal1 + " " + goal2);
            int total = 0;
            boolean goal1Met = false;
            boolean goal2Met = false;
            for(int j = 0; j < rides.length; j++) {
                total += Integer.parseInt(rides[j]);
                if(!goal1Met && total >= goal1) {
                    goal1Met = true;
                    System.out.print((j + 1) + " ");
                }
                if(!goal2Met && total >= goal2) {
                    goal2Met = true;
                    System.out.print((j + 1) + " ");
                }
            }
            if(!goal1Met)
                System.out.print("FAIL ");
            if(!goal2Met)
                System.out.print("FAIL ");
            if(numRides != 0)
                System.out.println(total / numRides);
            else
                System.out.println(0);
        }

        s.close();
    }

}
