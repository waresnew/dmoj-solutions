import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 5/2/2022

@SuppressWarnings("DuplicatedCode")
public class Luggage {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int size = readInt(), target = readInt();
        int[] luggage = new int[size];
        for (int i = 0; i < size; i++) {
            luggage[i] = readInt();
        }
        Arrays.sort(luggage);
        int[] diff = new int[size - 1];
        for (int i = 0; i < size - 1; i++) {
            diff[i] = luggage[i + 1] - luggage[i];
        }
        int[] diffPsa = new int[size - 1];
        for (int i = 0; i < size - 1; i++) {
            diffPsa[i] = diff[i];
            if (i != 0) {
                diffPsa[i] += diffPsa[i - 1];
            }
        }
        int left = 0, right = 0;
        int ans = 1;
        while (left < diff.length && right < diff.length) {
            if (diff[right] > target) {
                left = ++right;
                continue;
            }
            if (diffPsa[right] - (left == 0 ? 0 : diffPsa[left - 1]) > target) {
                left++;
            } else {
                ans = Math.max(ans, right - left + 1 + 1);
                right++;
            }
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