

import java.io.*;
import java.util.*;

public class Points {
    
    private static final String ALLOWED = "WDL";
    
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("points.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            int winPoints = s.nextInt();
            int drawPoints = s.nextInt();
            int lossPoints = s.nextInt();
            s.nextLine();
            String results = s.nextLine().trim();
            int total = 0;
            for(int j = 0; j < results.length(); j++) {
                char ch = results.charAt(j);
                assert ALLOWED.indexOf(ch) != -1 : "BAD CHAR IN RESULTS: " + i + " " + ch;
                if(ch == 'W')
                    total += winPoints;
                else if(ch == 'D')
                    total += drawPoints;
                else
                    total += lossPoints;
            }
            System.out.println(total);
        }
        s.close();
    }
    
 
}
