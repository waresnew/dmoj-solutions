import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-11-01

public class Rovarspraket {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        String input = readLine();
        String[] charArray = input.split("");
        char[] vowels = new char[]{
                97,
                101,
                105,
                111,
                117
        };
        for (int i = 0; i < charArray.length; i++) {
            char character = charArray[i].charAt(0);
            if (character != 'a' && character != 'e' && character != 'i' && character != 'o' && character != 'u') {
                int closestDifference = Integer.MAX_VALUE;
                char closestVowel = 123;
                for (char vowel : vowels) {
                    int difference = Math.abs(character - vowel);
                    if (difference == closestDifference) {
                        closestVowel = (char) Math.min(closestVowel, vowel);
                    } else if (difference < closestDifference) {
                        closestDifference = difference;
                        closestVowel = vowel;
                    }
                }
                char closestConsonant = 122;
                if (character + 1 == 'a' || character + 1 == 'e' || character + 1 == 'i' || character + 1 == 'o' || character + 1 == 'u') {
                    closestConsonant = (char) (character + 2);

                } else if (character != 'z') {
                    closestConsonant = (char) (character + 1);
                }

                charArray[i] = charArray[i] + closestVowel + closestConsonant;

            }
        }
        for (String string : charArray) {
            pr.print(string);
        }
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