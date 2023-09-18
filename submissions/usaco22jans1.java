import java.io.*;
import java.util.StringTokenizer;

// 9/27/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class SearchingForSoulmates {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfCows = readInt();
        for (int i = 0; i < numberOfCows; i++) {
            long a = readLong(), b = readLong();
            if (a == b) {
                pr.println(0);
                continue;
            }
            long ans = 0;
            long bestBreakoutAns = Long.MAX_VALUE;
            while (b > 1) {
                if (a > b) {
                    if (a % 2 != 0) {
                        a++;
                        ans++;
                    }
                    a /= 2;
                    ans++;
                } else if (b > a) {
                    long breakout = b - a;
                    bestBreakoutAns = Math.min(bestBreakoutAns, ans+breakout);
                    if (ans + breakout > bestBreakoutAns) {
                        break;
                    }
                    if (b % 2 != 0) {
                        b--;
                        ans++;
                    }
                    b /= 2;
                    ans++;
                } else {
                    bestBreakoutAns = Math.min(bestBreakoutAns, ans);
                    break;
                }
            }
            pr.println(bestBreakoutAns);
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