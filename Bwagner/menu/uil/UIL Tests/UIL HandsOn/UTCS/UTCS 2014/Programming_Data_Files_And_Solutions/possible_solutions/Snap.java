

public class Snap {
    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++) {
            boolean d2 = i % 2 == 0;
            boolean d3 = i % 3 == 0;
            boolean d5 = i % 5 == 0;
            if(d2)
                System.out.print("SNAP");
            if(d3)
                System.out.print("CRACKLE");
            if(d5)
                System.out.print("POP");
            if(!d2 && !d3 && !d5)
                System.out.print(i);
            System.out.println();
        }
    }
    
 
}
