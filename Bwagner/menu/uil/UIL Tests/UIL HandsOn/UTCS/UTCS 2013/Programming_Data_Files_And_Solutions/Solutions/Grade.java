package _UTCS_13;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Grade {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_13\\judges\\grade.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            System.out.println(s.nextLine());
            double hwp = s.nextInt() / 100.0;
            double qp = s.nextInt() / 100.0;
            double tp = s.nextInt() / 100.0;
            s.nextLine();
            int[] hw = stringsToInt(s);
            int[] qs = stringsToInt(s);
            assert hw != null & qs != null;
            int hwt = 0;
            for(int x : hw) {
                assert x >= 0;
                hwt += x;
            }
            int qt = 0;
            for(int x : qs) {
                assert x >= 0;
                qt += x;
            }
            double hwa = hwt * hwp / hw.length;
            double qa = qt * qp / qs.length;
            // System.out.println(hwa + " " + qa);
            int aNeed = (int) Math.ceil((90 - hwa - qa) / tp);
            int bNeed = (int) Math.ceil((80 - hwa - qa) / tp);
            int cNeed = (int) Math.ceil((70 - hwa - qa) / tp);
            System.out.println("A\t" + (aNeed > 100 ? "SORRY" : aNeed < 0 ? 0: aNeed));
            System.out.println("B\t" + (bNeed > 100 ? "SORRY" : bNeed < 0 ? 0: bNeed));
            System.out.println("C\t" + (cNeed > 100 ? "SORRY" : cNeed < 0 ? 0: cNeed));
        }
        s.close();
    }
    
    public static int[] stringsToInt(Scanner s) {
        String[] strings = s.nextLine().trim().split("\\s+");
        int[] scores = new int[strings.length];
        for(int k = 0; k < strings.length; k++)
            scores[k] = Integer.parseInt(strings[k]);
        return scores;
    }
    
 
}

