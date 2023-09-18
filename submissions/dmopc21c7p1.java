import java.io.*;
import java.util.StringTokenizer;

//Template generated on 4/11/2022

public class ChikaGrids {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) throws IOException {
        int rows = readInt(), columns = readInt();
        long[][] grid = new long[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = readLong();
            }
        }
        for (int i = 0; i < rows; i++) {
            long prev = -1;
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] != 0) {
                    prev = grid[i][j];
                    continue;
                }
                grid[i][j] = Math.max(prev, i == 0 ? 0 : grid[i - 1][j]) + 1;
                prev = grid[i][j];
            }
        }
        for (long[] row : grid) {
            long prev = 0;
            for (long cell : row) {
                if (cell <= prev) {
                    pr.println(-1);
                    pr.close();
                    return;
                }
                prev = cell;
            }
        }
        for (int i = 0; i < columns; i++) {
            long prev = 0;
            for (int j = 0; j < rows; j++) {
                if (grid[j][i] <= prev) {
                    pr.println(-1);
                    pr.close();
                    return;
                }
                prev = grid[j][i];
            }
        }
        for (long[] array : grid) {
            for (int i = 0; i < array.length; i++) {
                pr.print(array[i]);
                if (i != array.length - 1) {
                    pr.print(" ");
                }
            }
            pr.println();
        }
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
        return bufferedReader.readLine().trim();
    }
}