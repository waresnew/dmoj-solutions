import java.io.*;
import java.util.StringTokenizer;

// 9/20/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class HappyAlpacas {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int size = readInt(), target = readInt();
        int[] alpacas = new int[size+2];
        for (int i = 2; i <= target; i++) {
            alpacas[i] = alpacas[i-1]+2;
        }
        for (int i = target+1; i <= size;i++) {
            alpacas[i] = alpacas[i-1]+1;
        }
        alpacas[size+1] = alpacas[1];
        int happy = 0;
        for (int i = 1; i <= size; i++) {
            if ((alpacas[i] + alpacas[i+1])%2==0) {
                happy++;
            }
        }
        if (happy != target) {
            pr.println(-1);
            pr.close();
            return;
        }
        for (int i = 1; i <= size; i++) {
            pr.print(alpacas[i]);
            if (i != size) {
                pr.print(" ");
            }
        }
        pr.println();
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