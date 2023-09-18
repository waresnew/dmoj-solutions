import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2022-02-02

public class BobAndBusStops {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfStops = readInt(), numberOfQueries = readInt();
        int[] buses = new int[numberOfStops];
        for (int i = 0; i < numberOfStops; i++) {
            buses[i] = readInt();
        }
        Arrays.sort(buses);
        for (int i = 0; i < numberOfQueries; i++) {
            int left = readInt(), right = readInt();
            int leftIndex = binarySearch(buses, left, true);
            int rightIndex = binarySearch(buses, right, false);
            if (leftIndex == -1 || rightIndex == -1) {
                pr.println(0);
                continue;
            }
            pr.println(rightIndex - leftIndex + 1);
        }
        pr.close();
    }

    private static int binarySearch(int[] array, int key, boolean higher) {
        int low = 0, high = array.length - 1, answer = -1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (array[middle] == key) {
                return middle;
            }
            if (array[middle] > key) {
                high = middle - 1;
                if (higher) {
                    answer = middle;
                }
            } else {
                low = middle + 1;
                if (!higher) {
                    answer = middle;
                }
            }
        }
        return answer;
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