import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6/6/2022

@SuppressWarnings("DuplicatedCode")
public class UnluckyNumbers {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfUnlucky = readInt();
        int[] unlucky = new int[numberOfUnlucky];
        for (int i = 0; i < numberOfUnlucky; i++) {
            unlucky[i] =readInt();
        }
        Arrays.sort(unlucky);
        int numberOfApartments = readInt();
        for (int i = 0; i < numberOfApartments; i++) {
            int f = readInt();
            int left = ceilBinarySearch(unlucky, 1);
            int right = floorBinarySearch(unlucky, f);
            pr.println(f-(right-left+1));
        }
        pr.close();
    }

    private static String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens())
            stringTokenizer = new StringTokenizer(bufferedReader.readLine().trim());
        return stringTokenizer.nextToken();
    }
    private static int floorBinarySearch(int[] a, int key) {
        int low = 0, high = a.length - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
                ans = mid;
            } else {
                return mid;
            }
        }
        return ans;
    }

    private static int ceilBinarySearch(int[] a, int key) {
        int low = 0, high = a.length - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > key) {
                high = mid - 1;
                ans = mid;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return ans;
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