import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//Template generated on 3/23/2022

public class CyclopianPuzzle {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;


    public static void main(String[] args) throws IOException {
        int numberOfDiscs = readInt();
        move(numberOfDiscs, "A", "B", "C");
        pr.close();
    }

    private static void move(int number, String a, String b, String c) {
        if (number == 1) {
            pr.println(a + c);
            return;
        }
        move(number-1, a, c, b);
        pr.println(a + c);
        move(number-1, b, a, c);
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