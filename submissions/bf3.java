import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2022-02-08

public class NextPrime {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        int number = readInt();
        for (int i = number; i < Integer.MAX_VALUE; i++) {
            if (i == 1) {
                continue;
            }
            if (isPrime1(i)) {
                pr.println(i);
                pr.close();
                return;
            }
        }
        throw new Exception("for loop ended");
    }

    private static boolean isPrime1(int number) {
        for (int i = 2; i*i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime(int number) {
        boolean[] prime = new boolean[number + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i * i <= number; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= number; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime[number];
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