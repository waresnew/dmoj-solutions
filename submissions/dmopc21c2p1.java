import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bosses {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfLevels = readInt();
        int permTime = readInt();
        int tempTime = readInt();
        long totalTime = 0;
        int[] levels = new int[numberOfLevels];
        for (int i = 0; i < numberOfLevels; i++) {
            levels[i] = readInt();
            totalTime += levels[i];
        }
        long answer = totalTime * tempTime;
        Arrays.sort(levels);
        for (int i = 0; i < numberOfLevels; i++) {
            long perm = (long) permTime * levels[i];
            long temp = (totalTime - (long) (numberOfLevels - i) * levels[i]) * tempTime;
            answer = Math.min(answer, perm + temp);
            totalTime -= levels[i];
        }
        printer.println(answer);
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