import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 5/25/2022

@SuppressWarnings("DuplicatedCode")
public class StringPuzzle {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        for (int test = readInt(); test > 0; test--) {
            char[] a = next().toCharArray(), b = next().toCharArray();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            int cur = 0, target = 0;
            while (cur < a.length && target < b.length) {
                while (!stack.isEmpty() && stack.peek() == a[cur] && a[cur] < 'z') {
                    stack.pop();
                    a[cur]++;
                }
                if (stack.isEmpty() && a[cur] == b[target]) {
                    target++;
                } else {
                    stack.push(a[cur]);
                }
                cur++;
            }
            if (stack.isEmpty() && cur == a.length && target == b.length) {
                pr.println("YES");
            } else {
                pr.println("NO");
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
        return bufferedReader.readLine();
    }
}