import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-12-19

public class BobsTripPlan {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfAttractions = readInt() + 2;
        int[] attractions = new int[numberOfAttractions];
        int answer = 0;
        for (int i = 1; i < numberOfAttractions - 1; i++) {
            attractions[i] = readInt();
            answer += Math.abs(attractions[i] - attractions[i - 1]);
        }
        answer += Math.abs(attractions[numberOfAttractions - 2]);
        for (int i = 1; i < numberOfAttractions - 1; i++) {
            pr.println(answer - Math.abs(attractions[i - 1] - attractions[i]) - Math.abs(attractions[i] - attractions[i + 1]) + Math.abs(attractions[i - 1] - attractions[i + 1]));
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