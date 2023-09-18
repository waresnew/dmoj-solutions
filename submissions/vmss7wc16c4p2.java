import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

//Template generated on 3/1/2022

public class TestsOrTestCases {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static final HashSet<String> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {
        int numberOfRestrictions = readInt(), maxLength = readInt();
        @SuppressWarnings("unchecked")
        HashSet<String>[] restrictions = new HashSet[numberOfRestrictions];
        for (int i = 0; i < numberOfRestrictions; i++) {
            restrictions[i] = new HashSet<>();
        }
        for (int i = 0; i < numberOfRestrictions; i++) {
            int numberOfLetters = readInt();
            for (int j = 0; j < numberOfLetters; j++) {
                restrictions[i].add(next());
            }
        }
        for (String start : restrictions[0]) {
            generateWords(start, maxLength, restrictions, 0);
        }
        new TreeSet<>(answer).forEach(pr::println);
        pr.close();
    }

    private static void generateWords(String current, int maxLength, HashSet<String>[] restrictions, int restrictionStage) {
        answer.add(current);
        if (current.length() == maxLength) {
            return;
        }
        for (int i = restrictionStage + 1; i < restrictions.length; i++) {
            for (String string : restrictions[i]) {
                generateWords(current + string, maxLength, restrictions, i);
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
        return bufferedReader.readLine().trim();
    }
}