import java.io.*;
import java.util.StringTokenizer;

class PhoneNumber {
    final int number;
    final String name;
    int timesCalled = 0;

    PhoneNumber(String name, int number) {
        this.number = number;
        this.name = name;
    }
}

public class PhoneBook {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfPhones = readInt();
        PhoneNumber[] phoneNumbers = new PhoneNumber[numberOfPhones];
        for (int i = 0; i < numberOfPhones; i++) {
            phoneNumbers[i] = new PhoneNumber(next(), readInt());
        }
        int totalCalls = readInt();
        for (int i = 0; i < totalCalls; i++) {
            int number = readInt();
            for (PhoneNumber phoneNumber : phoneNumbers) {
                if (phoneNumber.number == number) {
                    phoneNumber.timesCalled++;
                }
            }
        }
        int highestTimesCalled = 0;
        int highestNumber = 0;
        String highestName = null;
        for (PhoneNumber phoneNumber : phoneNumbers) {
            if (phoneNumber.timesCalled == highestTimesCalled && phoneNumber.number < highestNumber) {
                highestNumber = phoneNumber.number;
                highestName = phoneNumber.name;
            } else if (phoneNumber.timesCalled > highestTimesCalled) {
                highestTimesCalled = phoneNumber.timesCalled;
                highestNumber = phoneNumber.number;
                highestName = phoneNumber.name;
            }
        }
        printer.println(highestName);
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