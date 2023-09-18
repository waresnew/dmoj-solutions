import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 10/17/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class HighTideLowTide {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int n = readInt(), measure[] = new int[n];
        for (int i = 0; i < n; i++) {
            measure[i] = readInt();
        }
        Arrays.sort(measure);
        Integer[] high = new Integer[n/2], low = new Integer[(int) Math.ceil(n/2.0)];
        for (int i = 0; i < low.length; i++) {
            low[i] = measure[i];
        }
        for (int i = 0; i < high.length; i++) {
            high[i] = measure[measure.length-i-1];
        }
        Arrays.sort(high);
        Arrays.sort(low, Comparator.reverseOrder());
        StringBuilder output = new StringBuilder();
        int lo = 0, hi = 0;
        for (int i = 0; i < measure.length; i++) {
            if (i % 2 == 0) {
                output.append(low[lo++] + " ");
            } else {
                output.append(high[hi++] + " ");
            }
        }
        pr.println(output.toString().trim());
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