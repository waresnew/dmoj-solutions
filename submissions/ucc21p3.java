import java.io.*;
import java.util.StringTokenizer;

// 5/24/2022

@SuppressWarnings("DuplicatedCode")
public class LongPizza {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int length = readInt();
        int[] pizza = new int[length+2];
        int left = readInt(), right = readInt();
        for (int i = readInt(); i > 0; i--) {
            pizza[readInt()]++;
            pizza[readInt()+1]--;
        }
        long ans = 0;
        for (int i = 1; i <= length; i++) {
            pizza[i] += pizza[i-1];
            if (i >= left && i <= right) {
                ans += pizza[i];
            }
        }
        pr.println(ans);
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