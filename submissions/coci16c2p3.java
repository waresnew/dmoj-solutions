import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Nizin {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int size = readInt();
        int[] number = new int[size];
        for (int i = 0; i < size; i++) {
            number[i] = Integer.parseInt(next());
        }
        int start = 0;
        int end = number.length - 1;
        int swaps = 0;
        int left = number[start];
        int right = number[end];
        while (start < end) {
            if (left == right) {
                start++;
                end--;
                left = number[start];
                right = number[end];
            } else if (left < right) {
                start++;
                left += number[start];
                swaps++;
            } else {
                end--;
                right += number[end];
                swaps++;
            }
        }

        printer.println(swaps);
        printer.close();
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