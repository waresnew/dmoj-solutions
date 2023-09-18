import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class HomeRow {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        ArrayDeque<Character> string = new ArrayDeque<>();
        String current = next();
        String target = next();
        char[] targetArray = target.toCharArray();
        int keystrokes = 0;
        for (char character : current.toCharArray()) {
            string.add(character);
        }
        ArrayDeque<Character> tempString = new ArrayDeque<>(string);
        int charsSameFromFirst = 0;
        for (int i = 0; i < current.length(); i++) {
            try {
                target.charAt(i);
            } catch (StringIndexOutOfBoundsException ex) {
                break;
            }
            if (!tempString.isEmpty() && tempString.pollFirst() == target.charAt(i)) {
                charsSameFromFirst++;
            } else {
                break;
            }
        }
        while (true) {
            if (string.isEmpty()) {
                keystrokes += target.length();
                break;
            }
            char next = string.peekLast();
            if (targetArray.length < string.size()) {
                string.removeLast();
                keystrokes++;
            } else if (next != targetArray[string.size() - 1] || charsSameFromFirst != string.size()) {
                string.removeLast();
                keystrokes++;
            } else {
                keystrokes += target.length() - charsSameFromFirst;
                break;
            }

        }
        printer.println(keystrokes);
        printer.close();
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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}