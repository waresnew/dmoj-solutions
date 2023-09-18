import java.io.*;
import java.util.StringTokenizer;

// 4/25/2022

@SuppressWarnings("DuplicatedCode")
public class Flipper {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int[][] grid = new int[2][2];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[1][0] = 3;
        grid[1][1] = 4;
        for (char ins : readLine().toCharArray()) {
            int one = grid[0][0];
            int two = grid[0][1];
            int three = grid[1][0];
            int four = grid[1][1];
            if (ins == 'H') {
                grid[1][0] = one;
                grid[1][1] = two;
                grid[0][0] = three;
                grid[0][1] = four;
            } else {
                grid[0][1] = one;
                grid[0][0] = two;
                grid[1][1] = three;
                grid[1][0] = four;
            }
        }
        pr.println(grid[0][0] + " " + grid[0][1]);
        pr.println(grid[1][0] + " " + grid[1][1]);
        pr.close();
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