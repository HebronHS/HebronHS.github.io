package _UTCS_13;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Us {
    public static void main(String[] args) throws IOException{

        
        // int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; 
        int[] nums = {100, 200, 300, 400, 500, 1000, 2000, 10000, 20000};
        
        int count = 0;
        int num = 1;
        int index = 0;
        while(index < nums.length) {
            if(isSelfNumber(num)) {
                count++;
                if(count == nums[index]) {
                    System.out.println(nums[index] + " " + num);
                    index++;
                }
            }
            num++;
        }
    }

    private static boolean isSelfNumber(int limit) {
        for(int i = 1; i < limit; i++) {
            if(sums(limit, i))
                return true;
        }
        return false;
    }

    private static boolean sums(int limit, int i) {
        int digits = 0;
        int orgNum = i;
        while(i > 0) {
            digits += i % 10;
            i /= 10;
        }
        // System.out.println(digits + " " + orgNum + " " + limit);
        return digits + orgNum == limit;
    }


}
