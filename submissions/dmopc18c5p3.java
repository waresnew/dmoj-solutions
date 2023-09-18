import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-11-30

public class AFamiliarProblem {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfCrayons = readInt();
        long targetCuteness = readLong();
        long[] crayonPsa = new long[numberOfCrayons+1];
        for (int i = 1; i <= numberOfCrayons; i++) {
            crayonPsa[i] = readLong() + crayonPsa[i - 1];
        }
        int largestLength = 0;
        for (int left = 1, right = 1; right <= numberOfCrayons; right++) {
            while (crayonPsa[right] - crayonPsa[left - 1] >= targetCuteness) {
                left++;
            }
            largestLength = Math.max(largestLength, right - left + 1);
        }
        pr.println(largestLength);
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