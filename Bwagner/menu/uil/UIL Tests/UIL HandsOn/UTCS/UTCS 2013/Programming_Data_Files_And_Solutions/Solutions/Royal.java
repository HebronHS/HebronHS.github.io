package _UTCS_13;

public class Royal {
    public static void main(String[] args) {
        goalPost();
        System.out.println("**********");
        for(int i = 10; i <= 40; i += 10)
            drawLines(i + "");

        drawCenter();
        
        for(int i = 30; i >= 10; i -= 10)
            drawLines(i + "");
        
        drawLines("**");
        goalPost();
        
    }
    
    public static void drawCenter() {
        System.out.println("*.\\....\\.*");
        System.out.println("*.\\\"DKR\".*");
        System.out.println("****50****");
        System.out.println("*.\\\"DKR\".*");
        System.out.println("*.\\....\\.*");
        System.out.println("****40****");
    }
    
    public static void drawLines(String insert) {
        assert insert.length() == 2;
        System.out.println("*.\\....\\.*");
        System.out.println("*.\\....\\.*");
        System.out.println("****" + insert + "****");
    }
    
    public static void goalPost() {
        System.out.println("..#....#..");
        System.out.println("..#....#..");
        System.out.println("..######..");
        System.out.println("....#.....");
        System.out.println("....#.....");
    }
}
