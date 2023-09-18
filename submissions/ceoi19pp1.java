import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

//Template generated on 2021-10-27

public class CountSquares {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int h = readInt(), v = readInt();
        int[] horizontalLines = new int[h];
        int[] verticalLines = new int[v];
        HashMap<Integer, Integer> yPairs = new HashMap<>();
        for (int i = 0; i < h; i++) {
            horizontalLines[i] = readInt();
            for (int j = 0; j < i; j++) {
                int difference = horizontalLines[i] - horizontalLines[j];
                yPairs.putIfAbsent(difference, 0);
                yPairs.put(difference, yPairs.get(difference) + 1);
            }
        }
        int answer = 0;
        for (int i = 0; i < v; i++) {
            verticalLines[i] = readInt();
            for (int j = 0; j < i; j++) {
                if (yPairs.containsKey(verticalLines[i] - verticalLines[j])) {
                    answer += yPairs.get(verticalLines[i] - verticalLines[j]);
                }
            }
        }
        pr.println(answer);
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