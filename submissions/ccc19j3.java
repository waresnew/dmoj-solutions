import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2022-02-06

public class ColdCompress {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int totalCases = readInt();
        for (int i = 0; i < totalCases; i++) {
            StringBuilder answer = new StringBuilder();
            char[] input = readLine().toCharArray();
            int length = 0;
            char currentChar = input[0];
            for (char character : input) {
                if (character == currentChar) {
                    length++;
                } else {
                    answer.append(length).append(" ").append(currentChar).append(" ");
                    currentChar = character;
                    length = 1;
                }
            }
            answer.append(length).append(" ").append(currentChar).append(" ");
            System.out.println(answer.toString().trim());
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