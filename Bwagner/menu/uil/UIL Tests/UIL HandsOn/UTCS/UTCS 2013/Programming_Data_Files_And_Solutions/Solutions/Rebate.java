package _UTCS_13;

import java.io.*;
import java.util.*;
import java.text.*;
/**
 * author: Moises Holguin
 * date: Monday, November 26, 2012
 * UTCS Problem
 * 
 * Modified by Mike Scott
 */
public class Rebate {
    public static void main(String[] args) throws IOException {
        Scanner infile = new Scanner(new File("UTCS_13\\judges\\rebate.dat"));
        infile.nextLine();

        while(infile.hasNext()) {

            String name = infile.nextLine();
            int num = Integer.parseInt(infile.nextLine());
            double total = 0;

            while(num-->0)
                total+=Double.parseDouble(infile.nextLine());

            if(total < 0)
                System.out.println(name + " BAD DATA");
            else {
                int rebate = (int) (Math.ceil(total*.1));
                int fives = rebate / 5;
                if(rebate % 5 > 0)
                    fives++;
                rebate = fives * 5;            
                // System.out.println(total);
                System.out.println(name + " " + rebate);
            }
        }
    }
}