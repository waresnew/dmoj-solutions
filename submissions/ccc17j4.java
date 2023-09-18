import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2022-02-08

public class FavouriteTimes {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfMinutes = readInt();
        int repeats = numberOfMinutes / 720;
        int remainder = numberOfMinutes % 720;
        final int repeatAmount = 31;
        int remainderAmount = 0;
        int answer = 0;
        for (int i = 720; i <= 720 + remainder; i++) {
            int hours = i / 60 % 12, minutes = i % 60;
            if (hours == 0) {
                hours = 12;
            }
            StringBuilder hoursString = new StringBuilder();
            for (String string : String.valueOf(hours).split("")) {
                hoursString.append(string);
            }
            String time = hoursString + (minutes < 10 ? "0" : "") + minutes;
            int difference = Integer.MIN_VALUE;
            int previousNumber = Integer.MIN_VALUE;
            boolean arithmeticSequence = true;
            String[] array = time.split("");
            for (String number : array) {
                int integer = Integer.parseInt(number);
                if (previousNumber != Integer.MIN_VALUE) {
                    if (difference == Integer.MIN_VALUE) {
                        difference = integer - previousNumber;
                    } else {
                        if (integer - previousNumber != difference) {
                            arithmeticSequence = false;
                            break;
                        }
                    }
                }
                previousNumber = integer;
            }
            if (arithmeticSequence) {
                remainderAmount++;
            }
        }
        answer += repeatAmount * repeats;
        answer += remainderAmount;

        pr.println(answer);
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