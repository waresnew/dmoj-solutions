import java.io.*;
import java.util.StringTokenizer;

// 6/6/2022

@SuppressWarnings("DuplicatedCode")
public class BrotherlySequence {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = readInt();
        }
        int ans = Integer.MIN_VALUE;
        for (int left = 0; left < n; left++) {
            label:
            for (int right = 0; right < n; right++) {
                if (right < left) {
                    continue;
                }
                for (int i = left; i <= right; i++) {
                    if (i != 0 && i != n-1) {
                        if ((i+1 <= right && Math.abs(numbers[i]-numbers[i+1])>2) || (i-1 >= left && Math.abs(numbers[i]-numbers[i-1])>2)) {
                            continue label;
                        }
                    }
                }
                ans = Math.max(ans, right-left+1);
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