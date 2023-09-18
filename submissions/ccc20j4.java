import java.io.*;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

//Template generated on 2022-01-20

public class CyclicShifts {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        String test = readLine(), word = readLine();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        HashSet<String> cyclics = new HashSet<>();
        for (char character : word.toCharArray()) {
            deque.add(character);
        }
        for (int i = 0; i < word.length(); i++) {
            char removed = deque.remove();
            deque.add(removed);
            StringBuilder newWord = new StringBuilder();
            for (Character character : deque) {
                newWord.append(character);
            }
            cyclics.add(newWord.toString());
        }
        for (String cyclic : cyclics) {
            if (test.contains(cyclic)) {
                pr.println("yes");
                pr.close();
                return;
            }
        }
        pr.println("no");
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