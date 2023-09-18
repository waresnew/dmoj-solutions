import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2022-01-28

public class AromaticNumbers {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        char[] input = readLine().toCharArray();
        int previousArabic = Integer.MIN_VALUE;
        int previousRoman = Integer.MIN_VALUE;
        int previousCombo = Integer.MIN_VALUE;
        int answer = 0;
        for (char character : input) {
            int number;
            boolean roman;
            try {
                number = Integer.parseInt(String.valueOf(character));
                roman = false;
            } catch (NumberFormatException ignored) {
                number = romanToArabic(character);
                roman = true;
            }
            if (!roman) {
                previousArabic = number;
            } else {
                if (previousRoman != Integer.MIN_VALUE) {
                    if (number > previousRoman) {
                        answer -= 2 * previousCombo;
                    }
                }
                answer += previousArabic * number;
                previousCombo = previousArabic * number;

                previousRoman = number;
            }
        }
        pr.println(answer);
        pr.close();
    }

    private static int romanToArabic(char roman) {
        switch (roman) {
            case 'I': {
                return 1;
            }
            case 'V': {
                return 5;
            }
            case 'X': {
                return 10;
            }
            case 'L': {
                return 50;
            }
            case 'C': {
                return 100;
            }
            case 'D': {
                return 500;
            }
            case 'M': {
                return 1000;
            }
        }
        throw new IllegalArgumentException("Not roman: " + roman);
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