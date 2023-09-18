import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

//Template generated on 4/3/2022

public class IntertwinedStrings {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static final HashSet<String> combos = new HashSet<>();

    public static void main(String[] args) throws IOException {
        String first = next(), second = next();
        combinations(new StringBuilder(), 0, 0, first.split(""), second.split(""));
        combos.forEach(pr::println);
        pr.close();
    }

    private static void combinations(StringBuilder current, int firstIndex, int secondIndex, String[] first, String[] second) {
        if (current.length() == first.length+second.length) {
            combos.add(current.toString());
            return;
        }

        if (firstIndex < first.length) {
            current.append(first[firstIndex]);
            combinations(current, firstIndex + 1, secondIndex, first, second);
            current.deleteCharAt(current.length() - 1);
        }
        if (secondIndex < second.length) {
            current.append(second[secondIndex]);
            combinations(current, firstIndex, secondIndex + 1, first, second);
            current.deleteCharAt(current.length() - 1);
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