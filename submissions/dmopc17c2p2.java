import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2022-01-28

public class Balance {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        String input = readLine();
        char[] array = input.toCharArray();
        int value = 0;
        int minimum = Integer.MAX_VALUE;
        for (char character : array) {
            if (character == '(') {
                value++;
            } else {
                value--;
            }
            minimum = Math.min(minimum, value);
        }
        if ((value == 0 && minimum >= 0) || (value == -2 && minimum >= -2) || (value == 2 && minimum >= 0)) {
            pr.println("YES");
        } else {
            pr.println("NO");
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