import java.io.*;
import java.util.StringTokenizer;

//Template generated on 4/5/2022

public class PalindromicNumbers {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        long left = readLong(), right = readLong();
        int answer = 0;
        for (int i = 1; i <= 1e6; i++) {
            String string = String.valueOf(i);
            long palindrome = Long.parseLong(string + new StringBuilder(string).reverse());
            long palindrome2 = Long.parseLong(string.substring(0, string.length() - 1) + new StringBuilder(string).reverse());
            if (palindrome <= right && palindrome >= left) {
                answer++;
            }
            if (palindrome2 <= right && palindrome2 >= left) {
                answer++;
            }
        }
        pr.println(answer);
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