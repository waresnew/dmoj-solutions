import java.io.*;
import java.util.StringTokenizer;

public class PumpkinPatches {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int totalPumpkins = readInt();
        int[] xCoords = new int[totalPumpkins];
        int[] yCoords = new int[totalPumpkins];
        for (int i = 0; i < totalPumpkins; i++) {
            xCoords[i] = readInt();
            yCoords[i] = readInt();
        }
        int highestXCoord = 0;
        int lowestXCoord = 0;
        int highestYCoord = 0;
        int lowestYCoord = 0;
        for (int xCoord : xCoords) {
            highestXCoord = Math.max(highestXCoord, xCoord);
            lowestXCoord = Math.min(lowestXCoord, xCoord);
        }
        for (int yCoord : yCoords) {
            highestYCoord = Math.max(highestYCoord, yCoord);
            lowestYCoord = Math.min(lowestYCoord, yCoord);
        }
        printer.println(2 * ((highestYCoord - lowestYCoord) + (highestXCoord - lowestXCoord)));
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