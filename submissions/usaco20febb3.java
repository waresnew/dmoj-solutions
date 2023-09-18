import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Template generated on 2021-12-02

public class SwapitySwap {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfCows = readInt(), numberOfOperations = readInt(), left1 = readInt(), right1 = readInt(), left2 = readInt(), right2 = readInt();
        int[] cows = new int[numberOfCows];
        for (int i = 1; i <= numberOfCows; i++) {
            cows[i - 1] = i;
        }
        for (int i = 1; i <= numberOfCows; i++) {
            if ((i <= right1 && i >= left1) || (i <= right2 && i >= left2)) {
                ArrayList<Integer> cycle = new ArrayList<>();
                int current = i;
                while (cycle.isEmpty() || current != i) {
                    cycle.add(current);
                    if (current <= right1 && current >= left1) {
                        current = left1 + right1 - current;
                    }
                    if (current <= right2 && current >= left2) {
                        current = left2 + right2 - current;
                    }
                }
                int operations = numberOfOperations % cycle.size();
                int index = cycle.get(operations);
                cows[index - 1] = i;
            }
        }
        for (int cow : cows) {
            pr.println(cow);
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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}