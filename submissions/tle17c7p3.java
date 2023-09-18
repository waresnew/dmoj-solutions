import java.io.*;
import java.util.StringTokenizer;

// 5/31/2022

@SuppressWarnings("DuplicatedCode")
public class CountlessCalculatorComputations {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        label:
        for (int query = readInt(); query > 0; query--) {
            int y = readInt(), z = readInt();
            double low = 1, high = 10;
            while (low <= high) {
                double mid = (low+high)/2;
                double z1 = power(mid, y);
                if (z1 > z) {
                    high = mid-0.00001;
                } else if (z1 < z) {
                    low = mid+0.00001;
                } else {
                    pr.println(z1);
                    continue label;
                }
            }
            pr.println((low+high)/2);
        }
        pr.close();
    }

    private static double power(double x, double y) {
        double ans = x;
        for (int i = 2; i <= y; i++) {
            ans = Math.pow(x, ans);
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