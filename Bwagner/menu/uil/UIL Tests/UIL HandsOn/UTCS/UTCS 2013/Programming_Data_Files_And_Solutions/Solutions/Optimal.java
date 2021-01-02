package _UTCS_13;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Optimal {
    public static void main(String args[]) throws IOException {
        Scanner scan = new Scanner(new File("UTCS_13\\judges\\optimal.dat"));

        int runs = scan.nextInt();
 
        // System.out.println(runs);
        for (int i = 0; i < runs; i++) {
            int numSequences = scan.nextInt();
            // System.out.println(numSequences);
            ArrayList<ArrayList<Integer>> sequences = new ArrayList<ArrayList<Integer>>();


            // Builds sequences of primes
            for (int j = 0; j < numSequences; j++) {
                sequences.add(new ArrayList<Integer>());
                int lowerBound = scan.nextInt(), upperBound = scan.nextInt();
                // System.out.println(lowerBound + " " + upperBound);
                assert lowerBound >= 2;
                if (lowerBound <= 2)
                    sequences.get(j).add(2);
                if (lowerBound <= 2)
                    lowerBound = 3;
                if (lowerBound % 2 == 0)
                    lowerBound++;

                for (; lowerBound <= upperBound; lowerBound += 2)
                    if (isPrime(lowerBound))
                        sequences.get(j).add(lowerBound);
            }

            // Creates all permutations
            ArrayList<String> permutations = new ArrayList<String>();
            getPermutations(sequences, permutations, new String(), 0);

//            if(numSequences == 9) {
//                System.out.println(permutations);
//                System.out.println(permutations.size());
//            }
            // Stores and sorts all found primes
            TreeSet<Integer> primes = new TreeSet<Integer>();
            for (int j = permutations.size() - 1; j >= 0; j--) {
                int k = Integer.parseInt(permutations.get(j));
                if (isPrime(k))
                    primes.add(k);
            }

            // System.out.println(primes);
            if (primes.size() != 0)
                System.out.println(primes.size());
            else 
                System.out.println("NO PRIMES");
        }
    }

    public static void getPermutations(ArrayList<ArrayList<Integer>> sequences, 
            ArrayList<String> permutations, String s,
            int index) {
        // System.out.println(s);
        if (index >= sequences.size()) {
            if(s.length() > 0)
                permutations.add(s);
            return;
        }

        if (sequences.get(index).isEmpty())
            getPermutations(sequences, permutations, s, index + 1);
        else for (Integer i : sequences.get(index))
            getPermutations(sequences, permutations, s + i, index + 1);
    }

    // disregards all even numbers, and numbers less than 2
//    public static boolean isPrime(int n) {
//        if(n == 2)
//            return true;
//        else if(n % 2 == 0)
//            return false;
//        int limit = (int)(Math.sqrt(n) + 1);
//        for (int i = 3; i <= limit; i += 2)
//            if (n % i == 0)
//                return false;
//        return true;
//    }
    
    public static boolean isPrime(int n) {
        BigInteger num = new BigInteger(n + "");
        return num.isProbablePrime(1000);
    }
}
