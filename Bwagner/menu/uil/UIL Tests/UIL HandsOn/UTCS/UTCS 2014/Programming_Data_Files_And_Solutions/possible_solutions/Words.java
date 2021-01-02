import java.io.*;
import java.util.*;

public class Words {
    public static void main(String[] args) throws IOException{
                  
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        Scanner s = new Scanner(new File("words.dat"));
        while(s.hasNextLine()) {
            String line = s.nextLine().trim();
            Scanner s2 = new Scanner(line);
            // System.out.println(line);
            int goodLetters = s2.nextInt();
            int badRunLength = s2.nextInt();
            int numDistinctLetters = s2.nextInt();
            String word = s2.next().trim();
            // System.out.println(word);
            if(goodLetters != alphabet.length() && containsBadChar(word, goodLetters, alphabet)) {
                //System.out.println("BAD LETTERS");
                System.out.println("NOT GOOD");
            }
            else if(runLengthBad(word, goodLetters, alphabet, badRunLength)) {
                //System.out.println("BAD RUN LENGTH");
                System.out.println("NOT GOOD");
            }
            else if(notEnoughDistinctChar(word, numDistinctLetters)) {
                //System.out.println("NOT ENOUGH DISTINCT LETTERS");
                System.out.println("NOT GOOD");
            }
            else 
                System.out.println("GOOD");
            //System.out.println();
        }
        s.close();
    }
    

    private static boolean notEnoughDistinctChar(String word,
            int numDistinctLetters) {
        Set<Character> chars = new HashSet<Character>();
        for(int i = 0; i < word.length(); i++)
            chars.add(word.charAt(i));
        return chars.size() < numDistinctLetters;
    }

    private static boolean runLengthBad(String word, int n, String alphabet,
            int badRunLength) {
        
        // If I were better at regular expressions I would use those
        
        // System.out.println(badRunLength);
        String goodLetters = alphabet.substring(0,n);
        for(int i = 0; i < goodLetters.length(); i++) {
            char currentLetter = goodLetters.charAt(i);
            String middle = "" + currentLetter;
            for(int j = 1; j < badRunLength; j++)
                middle += goodLetters.charAt(i);
            
            int currentPos = word.indexOf(middle);
            while(currentPos != -1) {
                int indexNextChar = currentPos + middle.length();
                int indexPrevChar = currentPos - 1;
                if( (indexPrevChar == -1 || word.charAt(indexPrevChar) != currentLetter)
                        && (indexNextChar == word.length() || word.charAt(indexNextChar) != currentLetter) )
                    return true;
                else
                    currentPos = word.indexOf(middle, currentPos + 1);
            }
        }
        return false;
    }

    public static boolean containsBadChar(String word, int n, String alphabet) {
        String bad = ".*[" + alphabet.substring(n + 1) + "].*";
        // System.out.println(bad);
        return word.matches(bad);
    }
}
