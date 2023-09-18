import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-11-26

public class WordProcessor {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfWords = readInt(), maxCharsPerLine = readInt();
        String[] words = new String[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {
            words[i] = next();
        }
        StringBuilder essay = new StringBuilder();
        int currentLineChars = 0;
        for (String word : words) {
            if (currentLineChars + word.length() > maxCharsPerLine) {
                essay.append("\n");
                currentLineChars = 0;
            }
            essay.append(word).append(" ");
            currentLineChars += word.length();
        }
        essay = new StringBuilder(essay.toString().replace(" \n", "\n"));
        essay = new StringBuilder(essay.substring(0, essay.length()-1));
        pr.println(essay);
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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}