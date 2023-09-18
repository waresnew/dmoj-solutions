import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2022-02-06

public class UnfriendFixed {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfPeople = readInt();
        int[] relation = new int[numberOfPeople], answer = new int[numberOfPeople];
        Arrays.fill(answer, 1);
        for (int i = 0; i < numberOfPeople - 1; i++) {
            relation[i] = readInt() - 1;
        }
        for (int i = 0; i < numberOfPeople - 1; i++) {
            answer[i]++;
            answer[relation[i]] *= answer[i];
        }
        pr.println(answer[numberOfPeople - 1]);
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