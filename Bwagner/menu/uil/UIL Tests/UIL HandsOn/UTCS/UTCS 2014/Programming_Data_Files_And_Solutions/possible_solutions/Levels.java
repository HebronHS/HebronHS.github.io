

public class Levels {

    static final int LINE_LENGTH = 64;

    public static void main(String[] args){
        String[] levels = 
        {       "OVERRIDING.HASHCODE().AND.NOT.OVERRIDING.EQUALS()",
                "NO.TRUE.REFERENCE.PARAMETERS",
                "ArrayIndexOutOfBoundsException",
                "THE.GREAT.PRIMITIVE-OBJECT.SCHISM",
                "OVERLOADING.INSTEAD.OF.OVERRIDING.EQUALS()",
                "LENGTH()..LENGTH.OR..SIZE().WOE.IS.US",
                "==.AND..EQUALS()-TEARS.UNNUMBERED",
                "NullPointerException.OF.DOOM",
                "ClassCastException"
        };
        for(int j = 0; j < levels.length; j++)
            drawLevel(j, levels[j]);
    }

    private static void drawLevel(int level, String string) {
        int periods = level * 2;
        int stars = LINE_LENGTH - periods * 2;
        printTopAndBotton(periods, stars);
        printMiddle(periods, stars, string);
        printTopAndBotton(periods, stars);

    }

    private static void printMiddle(int periods, int stars, String string) {
        printString(".", periods);
        printString("*", 1);
        int innerPeriods = stars - 2 - string.length();
        int startPeriods = innerPeriods / 2;
        int endPeriods = innerPeriods / 2 + innerPeriods % 2;

        printString(".", startPeriods);
        printString(string, 1);
        printString(".", endPeriods);
        printString("*", 1);
        printString(".", periods);

        System.out.println();
    }

    private static void printTopAndBotton(int periods, int stars) {
        printString(".", periods);
        printString("*", stars);
        printString(".", periods);
        System.out.println();
    }

    private static void printString(String s, int reps) {
        for(int i = 0; i < reps; i++)
            System.out.print(s);
    }


}
