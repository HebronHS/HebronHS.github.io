

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Scales {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("scales.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            System.out.print(i + " ");
            String word = s.nextLine().trim();
            assert word.equals(word.toUpperCase()) : "BAD DATA";
            boolean a = a(word);
            boolean d = d(word);
            if(a)
                System.out.print("A");
            if(d)
                System.out.print("D");
            if(!a && !d)
                System.out.print("N");
            System.out.println();
        }
        
        s.close();
    }

    private static boolean d(String word) {
        for(int i = 1; i < word.length(); i++) {
            char first = word.charAt(i - 1);
            char second = word.charAt(i);
            if(second > first)
                return false;
        }
        return true;
    }

    private static boolean a(String word) {
        for(int i = 1; i < word.length(); i++) {
            char first = word.charAt(i - 1);
            char second = word.charAt(i);
            if(second < first)
                return false;
        }
        return true;
    }
}
