import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-11-16

public class SimpleEncryption {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        char[] keyword = readLine().toCharArray();
        char[] preMessage = readLine().replaceAll("(?![ABCDEFGHIJKLMNOPQRSTUVWXYZ]).", "").toCharArray();
        int keywordIndex = 0;
        StringBuilder message = new StringBuilder();
        for (char character : preMessage) {
            char key = keyword[keywordIndex];
            int offset = key - 65;
            char newChar = (char) (character + offset);
            if (newChar > 90) {
                newChar = (char) (newChar % 91 + 65);
            }
            message.append(newChar);
            keywordIndex++;
            keywordIndex %= keyword.length;
        }
        pr.println(message);
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