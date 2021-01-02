
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Collatz {
    
    public static void main(String[] args) throws IOException {
        
        Scanner s = new Scanner(new File("collatz.dat"));
        while(s.hasNextInt()) {
            long org = s.nextInt();
            long n = org;
            int steps = 0;
            while(n != 1) {
                if(n <= 0)
                    throw new RuntimeException("n <= 0 for starting value: " + org);
                assert n >= 0 : "UH OVERFLOWED: " + org;
                steps++;
                if(n % 2 == 0)
                    n /= 2;
                else {
                    n = n * 3 + 1;
                }
            }
            System.out.println(steps);
        }
        s.close();
    }
}
