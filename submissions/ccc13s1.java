import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

// 11/18/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class From1987To2013 {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int cur = readInt();
        while (true) {
            cur++;
            String str = String.valueOf(cur);
            HashSet<Character> set = new HashSet<>();
            for (char c : str.toCharArray()){
                set.add(c);
            }
            if (set.size()==str.length()){
                pr.println(cur);
                pr.close();
                return;
            }

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
        return bufferedReader.readLine();
    }
}