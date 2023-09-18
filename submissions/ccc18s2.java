import java.io.*;
import java.util.StringTokenizer;

// 10/15/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class Sunflowers {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int days = readInt();
        int[][] grid = new int[days][days];
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < days; j++) {
                grid[i][j] = readInt();
            }
        }
        if (check(grid)) {
            print(grid);
            return;
        }
        //clockwise
        int[][] rotated1 = new int[days][days];
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < days; j++) {
                rotated1[i][grid.length-j-1] = grid[j][i];
            }
        }
        if (check(rotated1)) {
            print(rotated1);
            return;
        }
        //ccw
        int[][] rotated2 = new int[days][days];
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < days; j++) {
                rotated2[grid.length-j-1][i] = grid[i][j];
            }
        }
        if (check(rotated2)) {
            print(rotated2);
            return;
        }
        //180
        int[][] rotated3 = new int[days][days];
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < days; j++) {
                rotated3[grid.length-i-1][grid.length-j-1] = grid[i][j];
            }
        }
        if (check(rotated3)) {
            print(rotated3);
        }
    }

    private static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                pr.print(grid[i][j]);
                if (j!=grid.length-1) {
                    pr.print(" ");
                }
            }
            pr.println();
        }
        pr.close();
    }

    private static boolean check(int[][] grid) {
        int prev = -1;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0]>prev) {
                prev = grid[i][0];
            } else {
                return false;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            int prev2 = -1;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]>prev2) {
                    prev2 = grid[i][j];
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens())
            stringTokenizer = new StringTokenizer(bufferedReader.readLine().trim());
        return stringTokenizer.nextToken();
    }

    @SuppressWarnings("unused")
    private static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    @SuppressWarnings("unused")
    private static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    @SuppressWarnings("unused")
    private static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    /*
    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }
    */

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine();
    }
}