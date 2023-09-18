import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-12-06

public class BobsLightGame {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfLights = readInt(), numberOfOperations = readInt();
        int[] lightDiff = new int[numberOfLights];
        /*
        difference array to track number of toggles per bulb
        after restoring the array, even toggles = off, odd toggles = on
         */
        for (int i = 0; i < numberOfOperations; i++) {
            lightDiff[readInt() - 1]++;
            int right = readInt() - 1;
            if (right < numberOfLights - 1) {
                lightDiff[right + 1]--;
            }
        }
        int satisfied = 0;
        for (int i = 0; i < numberOfLights; i++) {
            lightDiff[i] += i == 0 ? 0 : lightDiff[i - 1];
            if (lightDiff[i] % 2 != 0) {
                satisfied++;
            }
        }
        pr.println(satisfied);
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