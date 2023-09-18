import java.io.*;
import java.util.StringTokenizer;

//Template generated on 4/3/2022

public class BobsMaximalSequenceSum {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int aLength = readInt(), b[] = new int[aLength-1];
        for (int i = 0; i < b.length; i++) {
            b[i] = readInt();
        }
        int[] answer = new int[aLength];
        answer[0] = b[0];
        long sum = b[0];
        for (int i = 1; i < answer.length; i++) {
            answer[i] = i == answer.length-1 ? b[b.length-1] :Math.min(b[i-1], b[i]);
            sum += answer[i];
        }
        pr.println(sum);
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