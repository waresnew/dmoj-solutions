import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2021-12-16

public class MimiAndBinary {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        char[] string = readLine().toCharArray();
        int[] zeroPsa = new int[string.length];
        int[] onePsa = new int[string.length];
        for (int i = 0; i < string.length; i++) {
            if (i > 0) {
                onePsa[i] += onePsa[i - 1];
            }
            if (string[i] == '1') {
                onePsa[i]++;
            }
        }
        for (int i = 0; i < string.length; i++) {
            if (i > 0) {
                zeroPsa[i] += zeroPsa[i - 1];
            }
            if (string[i] == '0') {
                zeroPsa[i]++;
            }
        }
        int numberOfQueries = readInt();
        for (int i = 0; i < numberOfQueries; i++) {
            int left = readInt() - 1, targetOccurrences = readInt(), targetNumber = readInt();
            int[] psa = targetNumber == 0 ? zeroPsa : onePsa;
            int result = Arrays.binarySearch(psa, left, psa.length, (left == 0 ? 0 : psa[left - 1]) + targetOccurrences);
            if (result < 0) {
                pr.println(-1);
            } else {
                for (int j = result; j >= 0; j--) {
                    if (j == 0 || psa[j] != psa[j - 1]) {
                        pr.println(j + 1);
                        break;
                    }
                }
            }
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