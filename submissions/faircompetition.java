import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6/12/2022

@SuppressWarnings("DuplicatedCode")
public class FairCompetition {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int total = readInt(), limit = readInt();
        int[] scores = new int[total];
        for (int i = 0; i < total; i++) {
            scores[i] = readInt();
        }
        Arrays.sort(scores);
        int low = 0, high = 75;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int honour = scores.length - binarySearch(scores, mid);
            if (honour > limit) {
                low = mid + 1;
            } else if (honour <= limit) {
                high = mid - 1;
                ans = Math.max(ans, honour);
            }
        }
        pr.println(ans);
        pr.close();
    }

    private static int binarySearch(int[] a, int key) {
        int low = 0, high = a.length - 1, ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] >= key) {
                ans = mid;
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            }
        }
        return ans;
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