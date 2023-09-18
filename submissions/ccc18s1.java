import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 10/15/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class VoronoiVillages {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfVillages = readInt();
        int[] villages = new int[numberOfVillages];
        for (int i = 0; i < numberOfVillages; i++) {
            villages[i] = readInt();
        }
        Arrays.sort(villages);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < numberOfVillages-1;i++) {
            ans = Math.min(ans, villages[i]-villages[i-1]+villages[i+1]-villages[i]);
        }
        pr.printf("%.1f", ans/2.0).println();
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