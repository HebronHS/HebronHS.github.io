import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr13
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr13.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	String s[] = kb.nextLine().split(" ");
  		char op = s[0].charAt(0);
      	int a = Integer.parseInt(s[1]);
      	int b = Integer.parseInt(s[2]);
      	switch(op) {
      		case '+': out.println(a + " " + op + " " + b + " = " + (a + b)); break;
      		case '-': out.println(a + " " + op + " " + b + " = " + (a - b)); break;
      		case '*': out.println(a + " " + op + " " + b + " = " + (a * b)); break;
      		case '\\': out.println(a + " " + op + " " + b + " = " + (a / b)); break;
      		case '/': out.print(a + " " + op + " " + b + " = ");
      				  out.printf("%.1f\n", ((double)a / b)); break;
      		case '%': out.println(a + " " + op + " " + b + " = " + (a % b)); break;
		}	
      }
   }
}

