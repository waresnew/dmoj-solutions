import java.io.*;
import java.util.StringTokenizer;

// 6/12/2022

@SuppressWarnings("DuplicatedCode")
public class SmallestNonSubstring {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        String s = readLine();
        for (int i = 97; i <= 122; i++) {
            if (!s.contains(String.valueOf((char) i))) {
                pr.println((char) i);
                pr.close();
                return;
            }
        }
        for (int i = 97; i <= 122; i++) {
            for (int j = 97; j <= 122; j++) {
                String string = (char) i + String.valueOf((char) j);
                if (!s.contains(string)) {
                    pr.println(string);
                    pr.close();
                    return;
                }
            }
        }

        throw new Exception();
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