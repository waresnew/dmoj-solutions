import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-11-01

public class SlotMachines {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int quarters = readInt();
        int firstCounter = readInt();
        int secondCounter = readInt();
        int thirdCounter = readInt();
        int currentMachine = 0;
        int counter = 0;
        while (quarters > 0) {
            counter++;
            quarters--;
            int current = currentMachine % 3;
            if (current == 0) {
                firstCounter++;
                if (firstCounter == 35) {
                    quarters += 30;
                    firstCounter = 0;
                }
            } else if (current == 1) {
                secondCounter++;
                if (secondCounter == 100) {
                    quarters += 60;
                    secondCounter = 0;
                }
            } else if (current == 2) {
                thirdCounter++;
                if (thirdCounter == 10) {
                    quarters += 9;
                    thirdCounter = 0;
                }
            }
            currentMachine++;
        }
        pr.printf("Martha plays %d times before going broke.", counter);
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