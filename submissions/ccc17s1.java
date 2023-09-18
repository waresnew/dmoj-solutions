import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-11-30

public class SumGame {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int seasonLength = readInt();
        int[] swiftsPsa = new int[seasonLength];
        int[] semaphoresPsa = new int[seasonLength];
        for (int i = 0; i < seasonLength; i++) {
            if (i == 0) {
                swiftsPsa[0] = readInt();
            } else {
                swiftsPsa[i] = readInt() + swiftsPsa[i - 1];
            }
        }
        for (int i = 0; i < seasonLength; i++) {
            if (i == 0) {
                semaphoresPsa[0] = readInt();
            } else {
                semaphoresPsa[i] = readInt() + semaphoresPsa[i - 1];
            }
        }
        int satisfiedDay = 0;
        for (int i = 1; i <= seasonLength; i++) {
            if (swiftsPsa[i - 1] == semaphoresPsa[i - 1]) {
                satisfiedDay = i;
            }
        }
        pr.println(satisfiedDay);
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