import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-12-01

public class ChocolateDay {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfCups = readInt(), timesFilled = readInt();
        int[] cupDiff = new int[numberOfCups + 2];
        int[] cupPsa = new int[numberOfCups + 1];
        for (int i = 1; i <= timesFilled; i++) {
            int start = readInt(), end = readInt(), amount = readInt();
            cupDiff[start] += amount;
            cupDiff[end + 1] -= amount;
        }
        for (int i = 1; i <= numberOfCups; i++) {
            cupDiff[i] += cupDiff[i - 1];
            cupPsa[i] = cupPsa[i - 1] + cupDiff[i];
        }
        int limit = readInt();
        int mostCups = 0;
        for (int left = 1, right = 1; right <= numberOfCups; right++) {
            while (cupPsa[right] - cupPsa[left - 1] > limit) {
                left++;
            }
            mostCups = Math.max(mostCups, right - left + 1);
        }
        pr.println(mostCups);
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