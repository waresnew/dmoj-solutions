import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-11-30

public class DaisyChains {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfFlowers = readInt();
        int[] flowers = new int[numberOfFlowers];
        for (int i = 0; i < numberOfFlowers; i++) {
            flowers[i] = readInt();
        }
        int[] flowerPsa = new int[numberOfFlowers];
        flowerPsa[0] = flowers[0];
        for (int i = 1; i < numberOfFlowers; i++) {
            flowerPsa[i] = flowers[i] + flowerPsa[i - 1];
        }
        int satisfied = 0;
        for (int i = 0; i < numberOfFlowers; i++) {
            for (int j = 0; j < numberOfFlowers; j++) {
                double average;
                if (i == 0) {
                    average = (double) flowerPsa[j] / (double) Math.abs(j - i + 1);
                } else {
                    average = (double) (flowerPsa[j] - flowerPsa[i - 1]) / (double) Math.abs(j - i + 1);
                }
                if (average % 1 == 0) {
                    for (int k = i; k <= j; k++) {
                        if (flowers[k] == average) {
                            satisfied++;
                            break;
                        }
                    }
                }
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