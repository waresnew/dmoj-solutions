import java.io.*;
import java.util.StringTokenizer;

//Template generated on 4/18/2022

public class VictorsMoralDilemma {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfTrolleys = readInt(), numberOfDays = readInt();
        int[] trolleysPsa = new int[numberOfTrolleys + 1];
        int start = 1, end = trolleysPsa.length - 1;
        for (int i = 1; i < trolleysPsa.length; i++) {
            trolleysPsa[i] = readInt();
            trolleysPsa[i] += trolleysPsa[i - 1];
        }
        for (int i = 0; i < numberOfDays; i++) {
            int index = readInt() + (start - 1);
            int left = trolleysPsa[index] - trolleysPsa[start - 1], right = trolleysPsa[end] - trolleysPsa[index];
            if (left >= right) {
                pr.println(left);
                start = index + 1;
            } else {
                pr.println(right);
                end = index;
            }
        }
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