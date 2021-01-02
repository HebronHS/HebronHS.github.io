package _UTCS_13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Dimensions {

    private static String INT_OR_DOUBLE = "[+]?[0-9]*\\.?[0-9]+([eE][+]?[0-9]+)?";

    public static void main(String args[]) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("UTCS_13\\judges\\dimensions.dat"));
        int numTests = scan.nextInt();

        scan.nextLine();
        for (int test = 0; test < numTests; test++) {
            String dimensions = getDimensions(scan.nextLine());
            if (dimensions == null)
                System.out.println("NO DIMENSION FOUND");
            else System.out.println(dimensions);
        }
    }

    public static String getDimensions(String text) {
        Pattern p = Pattern.compile(INT_OR_DOUBLE + "x" + INT_OR_DOUBLE + "x" + INT_OR_DOUBLE);
        Matcher m = p.matcher(text.replaceAll(" ", "").replaceAll("\t", "").toLowerCase());
        if (m.find())
            return m.group();
        return null;
    }
}