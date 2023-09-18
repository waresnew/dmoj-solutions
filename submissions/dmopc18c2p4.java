import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-11-30

public class DamageOutput {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int seconds = readInt();
        long targetDamage = readLong();
        long[] timeframes = new long[seconds];
        for (int i = 0; i < seconds; i++) {
            timeframes[i] = readLong();
        }
        long[] timeframePsa = new long[seconds];
        timeframePsa[0] = timeframes[0];
        for (int i = 1; i < seconds; i++) {
            timeframePsa[i] = timeframePsa[i - 1] + timeframes[i];
        }
        if (timeframePsa[timeframePsa.length - 1] < targetDamage) {
            pr.println(-1);
            pr.close();
            return;
        }
        int smallestLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (left < timeframes.length && right < timeframes.length) {
            if (left == 0) {
                if (timeframePsa[right] >= targetDamage) {
                    smallestLength = Math.min(smallestLength, right - left + 1);
                    left++;
                } else {
                    right++;
                }
            } else {
                if (timeframePsa[right] - timeframePsa[left - 1] >= targetDamage) {
                    smallestLength = Math.min(smallestLength, right - left + 1);
                    left++;
                } else {
                    right++;
                }
            }
        }
        pr.println(smallestLength);
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