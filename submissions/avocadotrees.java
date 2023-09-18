import java.io.*;
import java.util.StringTokenizer;

// 5/9/2022

@SuppressWarnings("DuplicatedCode")
public class AvocadoTrees {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfTrees = readInt(), numberOfRanges = readInt(), maxHeight = readInt();
        int[] treePsa = new int[numberOfTrees + 1];
        for (int i = 1; i <= numberOfTrees; i++) {
            int height = readInt(), avocado = readInt();
            treePsa[i] = treePsa[i - 1];
            if (height <= maxHeight) {
                treePsa[i] += avocado;
            }
        }
        int ans = 0;
        for (int i = 0; i < numberOfRanges; i++) {
            ans = Math.max(ans, -treePsa[readInt() - 1] + treePsa[readInt()]);
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