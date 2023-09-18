import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//Template generated on 2021-12-19

public class LeastWord {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfWords = readInt(), numberOfLetters = readInt();
        String[] words = new String[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {
            words[i] = next();
        }
        Comparator<String> comparator = (o1, o2) -> {
            boolean useAlternateo1 = false;
            boolean useAlternateo2 = false;
            if (o1.compareTo(new StringBuilder(o1).reverse().toString()) > 0) {
                useAlternateo1 = true;
            }
            if (o2.compareTo(new StringBuilder(o2).reverse().toString()) > 0) {
                useAlternateo2 = true;
            }
            if (useAlternateo1 && !useAlternateo2) {
                return new StringBuilder(o1).reverse().toString().compareTo(o2);
            } else if (!useAlternateo1 && useAlternateo2) {
                return o1.compareTo(new StringBuilder(o2).reverse().toString());
            } else if (useAlternateo1 && useAlternateo2) {
                return new StringBuilder(o1).reverse().toString().compareTo(new StringBuilder(o2).reverse().toString());
            } else {
                return o1.compareTo(o2);
            }
        };
        Arrays.sort(words, comparator);
        StringBuilder output = new StringBuilder();
        for (String word : words) {
            if (word.compareTo(new StringBuilder(word).reverse().toString()) > 0) {
                output.append(new StringBuilder(word).reverse());
            } else {
                output.append(word);
            }
        }
        pr.println(output);
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