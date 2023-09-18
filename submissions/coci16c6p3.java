import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 5/11/2022

@SuppressWarnings("DuplicatedCode")
public class Turnir {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int levels = readInt(), numbers[] = new int[(int) Math.pow(2, levels)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = readInt();
        }
        int[] sorted = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sorted);
        int[] answer = new int[numbers.length + 1];
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            while (i + 1 < levels && sorted[i] == sorted[i + 1]) {
                i++;
            }
            int num = i + 1, ans = 0;
            while (num != 1) {
                num /= 2;
                ans++;
            }
            answer[sorted[i]] = levels-ans;

        }
        for (int i= 0; i < numbers.length;i++) {
            string.append(answer[numbers[i]]).append(" ");
        }
        pr.println(string.toString().trim());
        pr.close();

    }


    private static int highestBinarySearch(int[] a, int key) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] > key) {
                hi = mid - 1;
            } else if (a[mid] < key) {
                lo = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] != key) {
                    return mid;
                }
                hi = mid - 1;
            }
        }
        return -1;
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