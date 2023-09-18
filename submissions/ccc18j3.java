import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-11-16

public class AreWeThereYet {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int[] differences = new int[]{
                readInt(),
                readInt(),
                readInt(),
                readInt()
        };
        int[] cities = new int[5];
        cities[0] = 0;
        for (int i = 1; i < 5; i++) {
            cities[i] = cities[i - 1] + differences[i - 1];
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                pr.print(Math.abs(cities[i] - cities[j]) + " ");
            }
            pr.println();
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