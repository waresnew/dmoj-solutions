import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11/18/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class TimeOnTask {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int time = readInt(), c = readInt();
        int[] chores = new int[c];
        for (int i = 0; i < c; i++) {
            chores[i] = readInt();
        }
        Arrays.sort(chores);
        int ans = 0;
        for (int i = 0; i < c; i++) {
            if (chores[i]<=time) {
                time-=chores[i];
                ans++;
            } else {
                break;
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