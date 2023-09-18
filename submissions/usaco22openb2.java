import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 4/21/2022

@SuppressWarnings("DuplicatedCode")
public class CountingLiars {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;


    public static void main(String[] args) throws IOException {
        int numberOfCows = readInt();
        ArrayList<Integer> greater = new ArrayList<>(1000);
        ArrayList<Integer> lesser = new ArrayList<>(1000);
        for (int i = 0; i < numberOfCows; i++) {
            if (next().equals("G")) {
                greater.add(readInt());
            } else {
                lesser.add(readInt());
            }
        }
        greater.sort(null);
        lesser.sort(null);
        int correct = Integer.MIN_VALUE;
        for (int left = 0, right = 0; right < greater.size(); right++) {
            while (left < lesser.size() && greater.get(right) > lesser.get(left)) {
                left++;
            }
            correct = Math.max(correct, right + 1 + (lesser.size() - left));
        }
        pr.println(numberOfCows - correct);
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