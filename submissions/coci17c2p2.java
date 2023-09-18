import java.io.*;
import java.util.*;

public class ZigZag {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfWords = readInt();
        int numberOfLetters = readInt();
        HashMap<Character, Integer> indexes = new HashMap<>();
        HashMap<Character, List<String>> words = new HashMap<>();
        char[] letters = new char[numberOfLetters];
        for (int i = 0; i < numberOfWords; i++) {
            String next = next();
            char firstLetter = next.charAt(0);
            if (words.get(firstLetter) == null) {
                words.put(firstLetter, new ArrayList<String>() {
                    @Override
                    public boolean add(String string) {
                        super.add(string);
                        Collections.sort(this);
                        return true;
                    }
                });
                indexes.put(firstLetter, 0);
            }
            words.get(firstLetter).add(next);
        }
        for (int i = 0; i < numberOfLetters; i++) {
            letters[i] = readCharacter();
        }

        for (char letter : letters) {
            List<String> wordList = words.get(letter);
            int index = indexes.get(letter) % wordList.size();
            printer.println(wordList.get(index));
            indexes.put(letter, indexes.get(letter) + 1);
        }
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