import java.io.*;
import java.util.StringTokenizer;

// 5/15/2022

@SuppressWarnings("DuplicatedCode")
public class ASubarrayProblem {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] perm = new int[n+1];
        int ans = 0, left = Integer.MAX_VALUE, right = 0;
        for (int i = 1; i <= n; i++) {
            perm[readInt()] = i;
        }
        for (int i = 1; i <= n; i++) {
            left = Math.min(left, perm[i]);
            right = Math.max(right, perm[i]);
            if (right-left+1 == i) {
                ans++;
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