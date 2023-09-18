import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

// 5/17/2022

@SuppressWarnings("DuplicatedCode")
public class HuffmanEncoding {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfChars = readInt();
        HashMap<String, String> rules = new HashMap<>();
        for (int i = 0; i < numberOfChars; i++) {
            String character = next(), binary = next();
            rules.put(binary, character);
        }
        String[] array = readLine().split("");
        StringBuilder cur = new StringBuilder(), ans = new StringBuilder();
        for (String s : array) {
            cur.append(s);
            if (rules.get(cur.toString()) != null) {
                ans.append(rules.get(cur.toString()));
                cur = new StringBuilder();
            }
        }
        pr.println(ans);
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