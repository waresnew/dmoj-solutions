import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

//Template generated on 2021-11-01

public class SnakesAndLadders {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> modifiers = new HashMap<>();
        modifiers.put(54, 19);
        modifiers.put(90, 48);
        modifiers.put(99, 77);
        modifiers.put(9, 34);
        modifiers.put(40, 64);
        modifiers.put(67, 86);
        int current = 1;
        while (true) {
            int die = readInt();
            if (die == 0) {
                pr.println("You Quit!");
                pr.close();
                return;
            }
            if (current + die <= 100) {
                current += die;
            }
            if (modifiers.containsKey(current)) {
                current = modifiers.get(current);
            }
            if (current == 100) {
                pr.println("You are now on square 100");
                pr.println("You Win!");
                pr.close();
                return;
            }
            pr.println("You are now on square " + current);
            pr.flush();
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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}