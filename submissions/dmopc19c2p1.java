import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2021-11-25

public class BoxAndWhiskers {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static int[] points;

    public static void main(String[] args) throws IOException {
        //follow the n/2 thing (int division)
        int numberOfPoints = readInt();
        points = new int[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++) {
            points[i] = readInt();
        }
        Arrays.sort(points);
        int minimum = points[0];
        int maximum = points[points.length - 1];

        double q1 = median(0, points.length / 2 - 1);
        double q2 = median(0, points.length - 1);
        double q3 = median(points.length - (points.length / 2), points.length - 1);
        DecimalFormat format = new DecimalFormat("0.#");
        pr.println(minimum + " " + maximum + " " + format.format(q1) + " " + format.format(q2) + " " + format.format(q3));
        pr.close();
    }

    private static double median(int start, int end) {
        int[] portion = new int[end - start + 1];
        int counter = 0;
        for (int i = start; i <= end; i++) {
            portion[counter++] = points[i];
        }
        if ((end - start + 1) % 2 == 0) {
            return (portion[portion.length / 2 - 1] + portion[portion.length / 2]) / 2.0;
        } else {
            return portion[portion.length / 2];
        }
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