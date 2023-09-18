import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-11-07

public class BobHistogram {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfBins = readInt();
        int[] bins = new int[numberOfBins];
        int sum = 0;
        for (int i = 0; i < numberOfBins; i++) {
            bins[i] = readInt();
            sum += bins[i];
        }


        int cost = 0;
        int desiredCost = (int) Math.round((double) sum / (double) bins.length);

        for (int bin : bins) {
            cost += Math.pow(bin - desiredCost, 2);
        }

        pr.println(cost);
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