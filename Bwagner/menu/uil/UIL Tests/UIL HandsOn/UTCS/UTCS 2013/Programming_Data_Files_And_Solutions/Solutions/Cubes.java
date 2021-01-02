package _UTCS_13;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cubes {
    
    public static Scanner key = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_13\\judges\\cubes.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        // Stopwatch st = new Stopwatch();
        
        for(int i = 1; i <= numSets; i++){
            String[] numsAsStrings = s.nextLine().trim().split("\\s+");

            int[] energies = new int[numsAsStrings.length];
            for(int j = 0; j < numsAsStrings.length; j++) 
                energies[j] = Integer.parseInt(numsAsStrings[j]);
            Arrays.sort(energies);
            // st.start();
            System.out.println(minBoxes(energies));
            // st.stop();
            // System.out.println(st);
        }
        s.close();
    }

    private static int minBoxes(int[] energies) {
        int boxes = 1;
        boolean solved = false;
        while(!solved) {
            solved = canWork(energies, boxes);
            // System.out.println(boxes);
            if(!solved) {
                boxes++;
                // System.out.println(boxes);
            }
        }
        return boxes;
    }

    private static boolean canWork(int[] energies, int numBoxes) {
        List<Integer>[] boxes = (List<Integer>[]) (new List[numBoxes]);
        for(int i = 0; i < boxes.length; i++)
            boxes[i] = new ArrayList<Integer>();

        return canWork(0, energies, boxes);
    }

    private static boolean canWork(int index, int[] energies, List<Integer>[] boxes) {
        if(index == energies.length) {
            // System.out.println(Arrays.toString(boxes));
            return true;
        }
            
        
        for(int b = 0; b < boxes.length; b++) {
            
            boxes[b].add(energies[index]);
            
            // System.out.println(Arrays.toString(boxes));
            // key.nextLine();
            
            if(noBadTriples(boxes) && canWork(index + 1, energies, boxes)) {
                return true;
            }
            boxes[b].remove(boxes[b].size() - 1);
        }
        return false;
    }

    private static boolean noBadTriples(List<Integer>[] boxes) {
        for(List<Integer> box : boxes) {
            if(badBox(box))
                return false;
        }
        return true;
    }

    private static boolean badBox(List<Integer> box) {
        for(int i = 0; i < box.size(); i++)
            for(int j = i + 1; j < box.size(); j++)
                for(int k = j + 1; k < box.size(); k++)
                    if(badTriple(box.get(i), box.get(j), box.get(k))) 
                        return true;
        return false;
    }

    private static boolean badTriple(int x, int y,int z) {
        return x + y == z || x + z == y || y + z == x;
    }


}
