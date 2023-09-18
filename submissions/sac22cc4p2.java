import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

//Template generated on 3/29/2022

public class ObligatoryStringProblem {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int maxScore = readInt();
        char[] target = readLine().toCharArray();

        HashSet<String> answer = new HashSet<>();
        for (int i = 97; i <= 122; i++) {
            for (int j = 97; j <= 122; j++) {
                for (int k = 97; k <= 122; k++) {
                    for (int l = 97; l <= 122; l++) {
                        String combo = "" + (char) i + (char) j + (char) k + (char) l;
                        int score = 0;
                        char[] array = combo.toCharArray();
                        for (int m = 0; m < 4; m++) {
                            int a = target[m]-97;
                            int b = array[m]-97;
                            score += Math.min(Math.abs(a-b), 26-Math.abs(a-b));
                        }
                        if (score <= maxScore) {
                            pr.println(combo);
                        }
                    }
                }
            }
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