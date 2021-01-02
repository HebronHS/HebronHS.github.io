package _UTCS_13;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Chuck {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_13\\judges\\chuck.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            int num = s.nextInt();
            assert num >= 0 && num <= 2000000000 : "num may not be negative";
            s.nextLine();
            int count = 0;
            for(int base = 2; base <= 16; base++) {
                String newNum = Integer.toString(num, base);
                // System.out.println(newNum);
                String revNewNum = new StringBuffer(newNum).reverse().toString();
                if(newNum.equals(revNewNum))
                    count++;
            }
            System.out.println(count);
        }
        s.close();
    }
}
