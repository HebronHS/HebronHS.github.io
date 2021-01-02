

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Prison {
    public static void main(String[] args) throws IOException{
        
        Scanner s = new Scanner(new File("prison.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            System.out.print(i + " ");
            char[][] maze = getMaze(s);
//            for(char[] row : maze)
//                System.out.println(Arrays.toString(row));
            SPoint start = findStart(maze);
            boolean[] escape = {false, false};
            solveMaze(start.r, start.c, maze, escape);
            String result = "";
            result += escape[0] ? "YES " : "NO ";
            result += escape[1] ? "YES" : "NO";
            System.out.println(result);
        }
        s.close();
    }

    private static final int[][] directions = {{-1, 0, 1, 0},
                                               {0, 1, 0, -1}};
   
    
    private static boolean solveMaze(int r, int c, char[][] maze, boolean[] escape) {
        if(!inbounds(maze, r, c))
            return false;
        // impassable??
        if(maze[r][c] == '*')
            return false;
        
        // found exit??
        if(maze[r][c] == 'E') {
            escape[0] = true;
            if(!redPresent(maze))
                escape[1] = true;
            return true;
        }
        // change current cell because we are going to try and leave
        char old = maze[r][c];
        if(old == 'R')
            maze[r][c] = 'G';
        else if(old == 'G')
            maze[r][c] = '*';
        else
            throw new RuntimeException("ENTERED BAD CELL: r: " + r + ", c: " + c);
        
        // not on exit, try four directions
        for(int i =0; i < directions[0].length; i++) {
            boolean foundExit = solveMaze(r + directions[0][i],
                    c + directions[1][i], maze, escape);
            if(foundExit && escape[1]) {
                // found way out and got all clues, all done
                return true;
            }
        }
        // never found way out, so reset cell
        maze[r][c] = old;
        return false;
    }

    private static boolean redPresent(char[][] maze) {
        for(char[] row : maze)
            for(char ch : row)
                if(ch == 'R')
                    return true;
        return false;
    }

    private static boolean inbounds(char[][] maze, int r, int c) {
        return 0 <= r && r < maze.length && 0 <= c && c < maze[r].length;
    }

    private static SPoint findStart(char[][] maze) {
        for(int r = 0; r < maze.length; r++)
            for(int c = 0; c < maze[r].length; c++)
                if(maze[r][c] == 'S') {
                    maze[r][c] = 'R';
                    return new SPoint(r, c);
                }
        return null;
    }

    private static char[][] getMaze(Scanner s) {
        int rows = s.nextInt();
        s.nextLine();
        char[][] result = new char[rows][];
        result[0] = s.nextLine().toCharArray();
        for(int r = 1; r < rows; r++) {
            result[r] = s.nextLine().toCharArray();
            assert result[r].length == result[0].length : "BAD LENGTH ON ROW IN PRISON: " 
                + r + " " + Arrays.toString(result[r]);
        }
        return result;
    }

    private static class SPoint {
        private int r, c;
        
        private SPoint(int ri, int ci) {
            r = ri;
            c = ci;
        }
    }

}
