import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-11-07

public class CountOddDigitNumbers {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        long number = readLong();
        long digits = String.valueOf(number).length();
        long satisfied = 0;
        if (digits == 1) {
            pr.println(number);
            pr.close();
            return;
        }
        if (digits > 1) {
            satisfied += 9;
            if (digits == 3) {
                satisfied += number - 99;
            }
        }
        if (digits > 3) {
            satisfied += 900;
            if (digits == 5) {
                satisfied += number - 9999;
            }

        }
        if (digits > 5) {
            satisfied += 90000;
            if (digits == 7) {
                satisfied += number - 999999;
            }

        }
        if (digits > 7) {
            satisfied += 9000000;
            if (digits == 9) {
                satisfied += number - 99999999;
            }
        }
        if (digits > 9) {
            satisfied += 900000000;
            if (digits == 11) {
                satisfied += number - 9999999999L;
            }
        }
        if (digits > 11) {
            satisfied += 90000000000L;
            if (digits == 13) {
                satisfied += number - 999999999999L;
            }
        }
        if (digits > 13) {
            satisfied += 9000000000000L;
            if (digits == 15) {
                satisfied += number - 99999999999999L;
            }
        }
        if (digits > 15) {
            satisfied += 900000000000000L;
            if (digits == 17) {
                satisfied += number - 9999999999999999L;
            }
        }
        if (digits > 17) {
            satisfied += 90000000000000000L;
            if (digits == 19) {
                satisfied += number - 999999999999999999L;
            }
        }
        pr.println(satisfied);
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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}