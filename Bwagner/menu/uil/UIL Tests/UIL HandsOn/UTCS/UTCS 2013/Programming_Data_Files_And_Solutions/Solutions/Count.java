package _UTCS_13;

import java.io.*;
import java.util.*;
/**
* author: Moises Holguin
* date: Monday, November 26, 2012
* UTCS Problem Counts Them Up
*/
public class Count {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("UTCS_13\\judges\\count.dat"));
        
        int numSets = Integer.parseInt(s.nextLine());
        
        for(int i = 0; i < numSets; i++) {
            String line = s.nextLine();
            int num1 = 0;
            int num2 = 0;
            
            //Handles the permutations
            if (line.contains("P")) {
                num1 = Integer.parseInt(line.substring(0, line.indexOf("P")));
                num2 = Integer.parseInt(line.substring(line.indexOf("P") + 1));
                
                assert 1 <= num1 && num1 <= 60 && 0 <= num2 && num2 <= 60;
                
                long answer = factorial(num1, num1 - num2);
                
                //This is how a person would normally tackle the problem
                //long answer = factorial(num1)/factorial(num1-num2);
                
                // BUT, that leads to overflow in many cases
                
                System.out.println(answer);
            }
            //Handles the combinations
            else {
                num1 = Integer.parseInt(line.substring(0, line.indexOf("C")));
                num2 = Integer.parseInt(line.substring(line.indexOf("C") + 1));
                long answer = factorial(num1, Math.max(num1 - num2, num2))/factorial(Math.min(num1 - num2, num2));
                
                //This is how a person would normally tackle the problem
                //long answer = factorial(num1)/(factorial(num1-num2)*factorial(num2));
                
                // BUT, that leads to overflow in many cases
                
                System.out.println(answer);
            }
        }
    }
    
    public static long factorial(int x) {
        if(x==0)
            return 1;
        else
            return x * factorial(x-1);
    }
    
    // avoid overflow
    public static long factorial(int x, int y) {
        if(x==0 || x==y)
            return 1;
        else
            return x * factorial(x-1, y);
    }
}
