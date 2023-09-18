import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-11-30

public class BattlePositions {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfStations = readInt(), troopsNeeded = readInt(), numberOfWaves = readInt();
        int[] stationDiff = new int[numberOfStations];
        for (int i = 0; i < numberOfWaves; i++) {
            int minIndex = readInt() - 1, maxIndex = readInt() - 1, numberOfTroops = readInt();
            if (maxIndex != stationDiff.length - 1) {
                stationDiff[maxIndex + 1] -= numberOfTroops;
            }
            stationDiff[minIndex] += numberOfTroops;
        }
        int previous = stationDiff[0];
        int unsatisfied = 0;
        if (stationDiff[0] < troopsNeeded) {
            unsatisfied++;
        }
        for (int i = 1; i < numberOfStations; i++) {
            int value = previous + stationDiff[i];
            if (value < troopsNeeded) {
                unsatisfied++;
            }
            previous = value;
        }
        pr.println(unsatisfied);
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