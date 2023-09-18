import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2022-02-24

public class FigureSkatingFun {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfPeople = readInt();
        int[] people = new int[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            people[i] = readInt();
        }
        int[] leftPsa = new int[numberOfPeople];
        int[] rightPsa = new int[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            leftPsa[i] = (i == 0 ? 0 : leftPsa[i - 1]) + people[i];
        }
        for (int i = numberOfPeople - 1; i >= 0; i--) {
            rightPsa[i] = (i == numberOfPeople - 1 ? 0 : rightPsa[i + 1]) + people[i];
        }
        for (int i = 0; i < numberOfPeople; i++) {
            if (i == numberOfPeople - 1) {
                continue;
            }
            if (leftPsa[i] == rightPsa[i + 1]) {
                pr.println(i + 1);
                pr.close();
                return;
            }
        }
        pr.println("Andrew is sad.");
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