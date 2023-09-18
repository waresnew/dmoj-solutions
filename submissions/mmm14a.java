import java.io.*;
import java.util.StringTokenizer;

// 5/18/2022

@SuppressWarnings("DuplicatedCode")
public class DistinctPrimeFactors {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int a = readInt(), b = readInt();
        int[] ans = new int[b + 1];
        for (int i = 2; i <= b; i++) {
            if (ans[i] == 0) {
                ans[i]++;
                for (int j = i * 2; j <= b; j += i) {
                    if (j % i == 0) {
                        ans[j]++;

                    }
                }
            }
        }
        for (int i = a; i <= b; i++) {
            pr.println(ans[i]);
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