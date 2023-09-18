import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 5/24/2022

@SuppressWarnings("DuplicatedCode")
public class EmeraldExchange {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Range {
        private final int from, to;

        private Range(int from, int to) {
            this.from = from;
            this.to = to;
        }
        @Override
        public String toString() {
            return from + " " + to;
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Range> ranges = new ArrayList<>();
        int[] emeralds = new int[readInt()];
        int prev = 0;
        for (int i = 0; i < emeralds.length; i++) {
            emeralds[i] = readInt();
            if (emeralds[i] % 2 !=0) {
                ranges.add(new Range(prev, i-1));
                prev = i+1;
            }
        }
        ranges.add(new Range(prev, emeralds.length-1));
        int ans = Integer.MIN_VALUE;
        for (Range range : ranges) {
            int sum = 0;
            for (int i = range.from; i <= range.to; i++) {
                sum += emeralds[i];
            }
            ans = Math.max(ans, sum);
        }
        pr.println(ans);
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