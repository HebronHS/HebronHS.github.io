import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr39 {
	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("pr39.dat"));
      	int times = Integer.parseInt(kb.nextLine().trim());
      	for(int z = 0; z < times; z++) {
			String[] s = kb.nextLine().trim().split(" ");
			char[] a = s[1].toCharArray();
			int size = Integer.parseInt(s[0]);  // get size of letter
			int rows = 2*size + 3;
			int cols = a.length * (size + 3);  // number of digits + empty col
			char[][] mat = new char[rows][cols];
			for(int j=0; j<rows; j++)		// fill matrix with ' '
				Arrays.fill(mat[j],' ');
			for(int j=0; j<a.length; j++) {
				int left = j * (size+2);      
				switch(a[j]) {
					case '2':		// all of these have 3 horizontal lines
					case '3':
					case '5':
					case '6':
					case '8':
					case '9': for(int x = left+j+1; x < left+j+1+size; x++) {
								mat[0][x] = '-';
								mat[rows/2][x] = '-';  	
								mat[rows-1][x] = '-';
							}
							break;
					// has 1 horizontal line in middle
					case '4': for(int x = left+j+1; x < left+j+1+size; x++) {
								mat[rows/2][x] = '-';  	
							}
							break;
					// has 1 horizontal line on top
					case '7': for(int x = left+j+1; x < left+j+1+size; x++) {
								mat[0][x] = '-';
							}
							break;
					// has 2 horizontal lines on top and bottom		
					case '0': for(int x = left+j+1; x < left+j+1+size; x++) {
								mat[0][x] = '-';
								mat[rows-1][x] = '-';
							}
							break;
					}
				switch(a[j]) {
					// vertical lines on outsides
					case '8':
					case '0':for(int x = 0; x < size; x++) {
								mat[x+1][(size+3)*j] = '|';   //top left
								mat[rows/2+x+1][(size+3)*j] = '|';   //bottom left 	
								mat[x+1][(size+3)*j+size+1] = '|';  //top right
								mat[rows/2+x+1][(size+3)*j+size+1] = '|';  //bottom right
							}
							break;
					// vertical line on right
					case '1':
					case '3': 
					case '7': for(int x = 0; x < size; x++) {
								mat[x+1][(size+3)*j+size+1] = '|';  //top right
								mat[rows/2+x+1][(size+3)*j+size+1] = '|';  //bottom right
							}
							break;
					// vertical lines on top right and bottom left
					case '2': for(int x = 0; x < size; x++) {
								mat[rows/2+x+1][(size+3)*j] = '|';   //bottom left 	
								mat[x+1][(size+3)*j+size+1] = '|';  //top right
							}
							break;
					// vertical lines on top left, top right and bottom right
					case '4': 
					case '9': for(int x = 0; x < size; x++) {
								mat[x+1][(size+3)*j] = '|';   //top left
								mat[x+1][(size+3)*j+size+1] = '|';  //top right
								mat[rows/2+x+1][(size+3)*j+size+1] = '|';  //bottom right
							}
							break;
					case '5': for(int x = 0; x < size; x++) {
								mat[x+1][(size+3)*j] = '|';   //top left
								mat[rows/2+x+1][(size+3)*j+size+1] = '|';  //bottom right
							}
							break;
					case '6': for(int x = 0; x < size; x++) {
								mat[x+1][(size+3)*j] = '|';   //top left
								mat[rows/2+x+1][(size+3)*j] = '|';   //bottom left 	
								mat[rows/2+x+1][(size+3)*j+size+1] = '|';  //bottom right
							}
							break;
					}	
				}
				
			for(int j=0; j<rows; j++)  {  // print matrix
				for(int k=0; k<cols; k++)
					System.out.print(mat[j][k]);
				System.out.println();
						
			}
			System.out.println();
		}
	}
}
