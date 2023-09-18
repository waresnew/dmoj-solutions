import java.io.*;
import java.util.StringTokenizer;

//Template generated on 3/29/2022

public class SortingDMOPC {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int size = readInt(), distance = readInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = readInt();
        }
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (numbers[i] != i + 1) {
                    if (i+distance < size && numbers[i+distance] < numbers[i]) {
                        swap(i+distance, i, numbers);
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if (numbers[i] != i + 1) {
                pr.println("NO");
                pr.close();
                return;
            }
        }
        pr.println("YES");
        pr.close();
    }

    private static void swap(int i, int j, int[] a) {
        int copy = a[i];
        a[i] = a[j];
        a[j] = copy;
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