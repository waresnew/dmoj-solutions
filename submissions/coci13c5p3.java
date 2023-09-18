import java.io.*;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.StringTokenizer;

// 4/26/2022

@SuppressWarnings("DuplicatedCode")
public class Eksplozjia {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        char[] string = readLine().toCharArray();
        char[] explosion = readLine().toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        stack.push('!');
        for (char value : string) {
            stack.push(value);
            if (stack.size() >= explosion.length) {
                int j = explosion.length - 1;
                boolean explode = true;
                for (char c : stack) {
                    if (c == '!') {
                        continue;
                    }
                    if (c != explosion[j]) {
                        explode = false;
                        break;
                    }
                    j--;
                    if (j < 0) {
                        break;
                    }
                }
                if (explode) {
                    for (int k = 0; k < explosion.length; k++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.size()==1) {
            pr.println("FRULA");
        } else {
            for (Iterator<Character> it = stack.descendingIterator(); it.hasNext(); ) {
                char c = it.next();
                if (c=='!') {
                    continue;
                }
                pr.print(c);
            }
        }
        pr.println();
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