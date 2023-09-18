import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-12-08

public class Harvest {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfRows = readInt(), numberOfColumns = readInt();
        long[] rowTotalsDiff = new long[numberOfRows];
        long targetPotatoes = readLong();
        if (targetPotatoes == 0) {
            pr.println(0);
            pr.close();
            return;
        }
        rowTotalsDiff[0] = numberOfColumns;
        for (int i = 0; i < numberOfColumns; i++) {
            int start = readInt() - 1, end = readInt() - 1;
            rowTotalsDiff[start]--;
            if (end != numberOfRows - 1) {
                rowTotalsDiff[end + 1]++;
            }
        }
        for (int i = 1; i < numberOfRows; i++) {
            rowTotalsDiff[i] += rowTotalsDiff[i - 1];
        }
        for (int i = 1; i < numberOfRows; i++) {
            rowTotalsDiff[i] += rowTotalsDiff[i - 1];
        }
        int up = 0, down = 0;
        int smallestWidth = Integer.MAX_VALUE;
        while (up < numberOfRows && down < numberOfRows) {
            long potatoes = rowTotalsDiff[down] - (up > 0 ? rowTotalsDiff[up - 1] : 0);
            if (potatoes >= targetPotatoes) {
                smallestWidth = Math.min(smallestWidth, down - up + 1);
                up++;
            } else {
                down++;
            }
        }
        pr.println(smallestWidth == Integer.MAX_VALUE ? -1 : smallestWidth);
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