import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Template generated on 2021-11-01

public class Kartomat {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfDestinations = readInt();
        String[] destinations = new String[numberOfDestinations];
        String[] keyboard = new String[]{
                "*", "*", "*", "A", "B", "C", "D", "E", "\n",
                "F", "G", "H", "I", "J", "K", "L", "M", "\n",
                "N", "O", "P", "Q", "R", "S", "T", "U", "\n",
                "V", "W", "X", "Y", "Z", "*", "*", "*"
        };
        for (int i = 0; i < numberOfDestinations; i++) {
            destinations[i] = readLine();
        }
        String input = readLine();
        ArrayList<String> valid = new ArrayList<>();
        for (String destination : destinations) {
            if (destination.startsWith(input)) {
                valid.add(destination);
            }
        }
        char next = input.charAt(input.length() - 1);
        ArrayList<String> displayableCharacters = new ArrayList<>();
        displayableCharacters.add("\n");
        for (String destination : valid) {
            displayableCharacters.add(String.valueOf(destination.charAt(input.length())));
        }
        for (String key : keyboard) {
            if (displayableCharacters.contains(key)) {
                pr.print(key);
            } else {
                pr.print("*");
            }
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