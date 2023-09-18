import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2022-02-14

public class StringCrossingMaximization {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int length1 = readInt(), length2 = readInt();
        String word1 = readLine(), word2 = readLine();
        long[] freq1 = new long[26], freq2 = new long[26];
        for (int i = 0; i < length1; i++) {
            freq1[word1.charAt(i) - 'A']++;
        }
        for (int i = 0; i < length2; i++) {
            freq2[word2.charAt(i) - 'A']++;
        }
        long baseCrossings = 0;
        for (int i = 0; i < 26; i++) {
            baseCrossings += freq1[i] * freq2[i];
        }
        long highestCrossings = Long.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (freq2[j] == 0) continue;
                long crossings = baseCrossings - freq1[i] * freq2[i] - freq1[j] * freq2[j];
                long potential = (freq2[i] + 1) * freq1[i];
                long cost = (freq2[j] - 1) * freq1[j];
                highestCrossings = Math.max(crossings + potential + cost, highestCrossings);

            }
        }


        pr.println(highestCrossings);
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