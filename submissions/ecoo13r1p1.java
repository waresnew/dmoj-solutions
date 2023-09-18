import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 4/25/2022

@SuppressWarnings("DuplicatedCode")
public class TakeANumber {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int top = readInt();
        int totalLate = 0;
        int queueSize = 0;
        while (true) {
            String input = readLine();
            if (input.equals("EOF")) {
                break;
            }
            if (input.equals("TAKE")) {
                top++;
                queueSize++;
                totalLate++;
                if (top == 1000) {
                    top = 1;
                }
            }
            if (input.equals("SERVE")) {
                queueSize--;
            }
            if (input.equals("CLOSE")) {
                pr.printf("%d %d %d", totalLate, queueSize, top).println();
                queueSize = 0;
                totalLate = 0;
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
        return bufferedReader.readLine();
    }
}