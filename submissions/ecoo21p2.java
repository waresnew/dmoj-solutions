import java.io.*;
import java.util.StringTokenizer;

// 5/2/2022

@SuppressWarnings("DuplicatedCode")
public class DNADarren {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        char[] target = readLine().toCharArray();
        boolean needVowel = false;
        boolean needConsonant = false;
        for (char c : target) {
            if (c == 'A') {
                needVowel = false;
                if (needConsonant) {
                    pr.print(" ");
                }
                needConsonant = true;
            }
            if (c != 'A') {
                needConsonant = false;
                if (needVowel) {
                    pr.print(" ");
                }
                needVowel = true;
            }
            pr.print(c);
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
        return bufferedReader.readLine();
    }
}