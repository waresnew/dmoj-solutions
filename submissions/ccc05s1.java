import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-12-06

public class SnowCalls {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfPhoneNumbers = readInt();
        String[] phoneNumbers = new String[numberOfPhoneNumbers];
        for (int i = 0; i < numberOfPhoneNumbers; i++) {
            phoneNumbers[i] = readLine().replace("-", "");
        }
        String[] keys = new String[]{
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
        for (String phoneNumber : phoneNumbers) {
            StringBuilder newNumber = new StringBuilder();
            String[] characters = phoneNumber.split("");
            for (String character : characters) {
                try {
                    Integer.parseInt(character);
                    newNumber.append(character);
                } catch (NumberFormatException ignored) {
                    for (int i = 0; i < keys.length; i++) {
                        if (keys[i].contains(character.toLowerCase())) {
                            newNumber.append(i + 1);
                        }
                    }
                }
            }
            pr.println(newNumber.substring(0, 3) + "-" + newNumber.substring(3, 6) + "-" + newNumber.substring(6, 10));
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