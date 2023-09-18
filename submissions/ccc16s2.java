import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2022-02-08

public class TandemBicycleCCC {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int questionType = readInt(), numberOfPeople = readInt();
        int[] dmoj = new int[numberOfPeople], peg = new int[numberOfPeople];
        int[] total = new int[numberOfPeople * 2];
        for (int i = 0; i < numberOfPeople; i++) {
            dmoj[i] = readInt();
            total[i] = dmoj[i];
        }
        for (int i = 0; i < numberOfPeople; i++) {
            peg[i] = readInt();
            total[i + numberOfPeople] = peg[i];
        }
        Arrays.sort(dmoj);
        Arrays.sort(peg);
        Arrays.sort(total);
        int answer = 0;
        if (questionType == 2) {
            for (int i = 1; i <= numberOfPeople; i++) {
                answer += total[numberOfPeople * 2 - i];
            }
        } else {
            for (int i = 0; i < numberOfPeople; i++) {
                answer += Math.max(dmoj[i], peg[i]);
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