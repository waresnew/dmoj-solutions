import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2021-12-06

public class SleepyCowHerding {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int[] cows = new int[]{readInt(), readInt(), readInt()};
        Arrays.sort(cows);
        if (cows[2] - cows[1] == 1 && cows[1] - cows[0] == 1) {
            pr.println(0);
            pr.println(0);
            pr.close();
            return;
        }
        if (cows[1] - cows[0] == 2 || cows[2] - cows[1] == 2) {
            pr.println(1);
        } else {
            pr.println(2);
        }

        int startToMid = cows[1] - cows[0];
        int midToEnd = cows[2] - cows[1];
        if (startToMid > midToEnd) {
            pr.println(startToMid - 1);
        } else {
            pr.println(midToEnd - 1);
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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}