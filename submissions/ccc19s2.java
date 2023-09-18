import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2022-02-04

public class PrettyAveragePrimes {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfCases = readInt();
        for (int testCase = 0; testCase < numberOfCases; testCase++) {
            int number = readInt();
            for (int i = 2; i <= number * 2 - 1; i += 2) {
                int number1 = i, number2 = 2 * number - i;
                if (isPrime(number1) && isPrime(number2) && number1 + number2 == 2 * number) {
                    pr.println(number1 + " " + number2);
                    break;
                }
                if (i == 2) {
                    i = 1; //skip to 3
                }
            }
        }
        pr.close();
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
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