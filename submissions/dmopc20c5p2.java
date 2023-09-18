import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 5/17/2022

@SuppressWarnings("DuplicatedCode")
public class OnTheClock {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Coordinate implements Comparable<Coordinate> {
        private final int row, column;

        private Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public String toString() {
            return row + " " + column;
        }


        @Override
        public int compareTo(Coordinate o) {
            int comp1 = Integer.compare(row, o.row);
            if (comp1 == 0) {
                return Integer.compare(column, o.column);
            }
            return comp1;
        }
    }

    public static void main(String[] args) throws IOException {
        long numberOfRows = readLong(), numberOfColumns = readLong();
        TreeSet<Coordinate> ans = new TreeSet<>();
        for (int column = 1; column <= numberOfColumns; column++) {
            long leftRow = (numberOfRows * (column - 1)) / numberOfColumns + 1;
            long rightRow = (numberOfRows * column + numberOfColumns - 1) / numberOfColumns;
            for (long i = leftRow; i <= rightRow; i++) {
                ans.add(new Coordinate((int) i, column));
            }
        }
        pr.println(ans.size());
        for (Coordinate c : ans) {
            pr.println(c.toString());
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
        return bufferedReader.readLine();
    }
}