import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2022-02-24

public class ArithmeticOrGeometric {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfCases = readInt();
        for (int test = 0; test < numberOfCases; test++) {
            long first = readLong(), second = readLong(), third = readLong(), target = readLong();
            if (third - second == second - first) {
                long diff = third - second;
                pr.println(((target-1) * diff + first)%(int) (1e9+7));
            } else {
                long ratio = third / second;
                pr.println((first * power(ratio, target - 1, (int) (1e9+7))) %(int) (1e9+7));
            }
        }
        pr.close();
    }

    private static long power(long base, long exponent, int mod) {
        if (exponent == 0) {
            return 1;
        }
        long remainder = power(base, exponent / 2, mod);
        remainder = remainder * remainder % mod;
        if (exponent % 2 != 0) {
            remainder = remainder * base % mod;
        }
        return remainder;
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