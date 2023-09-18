import java.io.*;
import java.util.StringTokenizer;

// 6/12/2022

@SuppressWarnings("DuplicatedCode")
public class PopularBread {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfBread = readInt(), numberOfCustomers = readInt();
        int[] breads = new int[numberOfBread+2];
        for (int i = 0; i < numberOfCustomers; i++) {
            breads[readInt()]++;
            breads[readInt()+1]--;
        }
        int ans = 0;
        for (int i = 1; i <= numberOfBread; i++) {
            breads[i] += breads[i-1];
        }
        for (int bread : breads) {
            if (bread == numberOfCustomers) {
                ans++;
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