import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2022-01-30

public class PermutationsAndPrimes {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int number = readInt();
        if (number == 1) {
            pr.println(1);
            pr.close();
            return;
        }
        if (number <= 4) {
            pr.println(-1);
            pr.close();
            return;
        }
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= number; i += 2) {
            if (i == 5) continue;
            output.append(i).append(" ");
        }
        output.append(5 + " " + 4 + " ");
        for (int i = 2; i <= number; i += 2) {
            if (i == 4) continue;
            output.append(i).append(" ");
        }
        pr.println(output.toString().trim());
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
        return bufferedReader.readLine().trim();
    }
}