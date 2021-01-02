
import java.io.*;
import java.util.*;

public class Golf {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("golf.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            String[] clubsAsStrings = s.nextLine().trim().split("\\s+");
            int[] clubs = new int[clubsAsStrings.length];
            for(int j = 0; j < clubs.length; j++)
                clubs[j] = Integer.parseInt(clubsAsStrings[j]);
            int distance = s.nextInt();
            s.nextLine();
            int result = minHits(distance, clubs);
            if(result == -1)
                System.out.println("NOT POSSIBLE");
            else
                System.out.println(result);
        }
        s.close();
    }
    
    public static int minHits(int distance, int[] clubs) {
        // base case, 0 hits required to hit ball 0 distance
        if(distance == 0)
            return 0;
        // if distance is negative can't do it
        else if(distance < 0)
            return -1;
        else{
            int best = distance + 1; // best has to be better than this if possible
            // try all the clubs
            for(int i = 0; i < clubs.length; i++) {
                int current = 1 + minHits(distance - clubs[i], clubs);
                if(current != 0 && current < best)
                    best = current;

            }
            if(best == distance + 1)
                // never found an answer!
                best = -1;
            return best;
        }
    }

    
 
}

