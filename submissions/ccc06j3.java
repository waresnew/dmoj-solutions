import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Template generated on 2021-12-06

public class CellPhoneMessaging {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static String[] keys = new String[]{
            "123",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public static void main(String[] args) throws IOException {
        ArrayList<String> words = new ArrayList<>();
        while (true) {
            String word = next();
            if (word.equals("halt")) {
                break;
            }
            words.add(word);
        }

        for (String word : words) {
            int time = 0;
            String[] chars = word.split("");
            int previous = -1;
            for (String character : chars) {
                int key = getKey(character);
                if (character.matches("[adgjmptw]")) {
                    time++;
                } else if (character.matches("[behknqux]")) {
                    time += 2;
                } else if (character.matches("[cfilorvy]")) {
                    time += 3;
                } else if (character.matches("[sz]")) {
                    time += 4;
                }
                if (previous == key) {
                    time += 2;
                }
                previous = key;
            }
            pr.println(time);
        }
        pr.close();
    }

    private static int getKey(String character) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].contains(character)) {
                return i;
            }
        }
        return -1;
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