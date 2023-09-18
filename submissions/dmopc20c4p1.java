import java.io.*;
import java.util.StringTokenizer;

//Template generated on 4/11/2022

public class MissingNumbers {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int cases = readInt();
        for (int test = 0; test < cases; test++) {
            long length = readLong();
            long sum = readLong();
            if (length == 2) {
                pr.println(1);
                continue;
            }
            long expected = (length * (length + 1)) / 2;
            long diff = expected - sum;
            long ans = diff / 2 - (Math.max(0, diff - 1 - length));
            if (diff % 2 == 0) {
                ans--;
            }
            if (ans < 0) {
                ans = 0;
            }

            pr.println(ans);
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
        return bufferedReader.readLine().trim();
    }
}