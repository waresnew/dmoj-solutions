import java.io.*;
import java.util.StringTokenizer;

// 10/27/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class WanderingBilly {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        for (int test = 0; test < 5; test++) {
            int n = readInt();
            int right = 0, down = 0;
            int cur = 1, steps = 0;
            for (int i = 1; i <= n; i++) {
                if (cur % 2 == 0) {
                    down++;
                } else {
                    right++;
                }
                steps++;
                if (steps == cur) {
                    cur++;
                    steps = 0;
                }
            }
            pr.println(right + " " + -down);
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