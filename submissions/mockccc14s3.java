import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//Template generated on 2021-11-28

public class SpreadsheetSorting {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static int column;

    public static void main(String[] args) throws IOException {
        int numberOfRows = readInt(), numberOfColumns = readInt();
        int[][] grid = new int[numberOfRows][numberOfColumns];
        Integer[] rows = new Integer[numberOfRows];
        for (int i = 0; i < numberOfRows; i++) {
            rows[i] = i;
            for (int j = 0; j < numberOfColumns; j++) {
                grid[i][j] = readInt();
            }
        }
        int numberOfSorts = readInt();

        Comparator<Integer> comparator = Comparator.comparingInt(o -> grid[o][column]);
        for (int i = 0; i < numberOfSorts; i++) {
            column = readInt() - 1;
            Arrays.sort(rows, comparator);
        }
        for (int i = 0; i < numberOfRows; i++) {
            int row = rows[i];
            for (int j = 0; j < numberOfColumns; j++) {
                pr.print(grid[row][j] + " ");
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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}