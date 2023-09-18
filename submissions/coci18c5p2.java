import java.io.*;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;

//Template generated on 2021-10-27

public class Jarvis {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Drone {
        private final int factory;
        private int required;

        private Drone(int factory) {
            this.factory = factory;
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfDrones = readInt();
        Drone[] drones = new Drone[numberOfDrones];
        for (int i = 0; i < numberOfDrones; i++) {
            drones[i] = new Drone(readInt());
        }
        for (int i = 0; i < numberOfDrones; i++) {
            drones[i].required = readInt();
        }
        TreeMap<Integer, Integer> differences = new TreeMap<>();
        for (int i = 0; i < numberOfDrones; i++) {
            int difference = drones[i].required - drones[i].factory;
            differences.putIfAbsent(difference, 0);
            differences.put(difference, differences.get(difference) + 1);
        }
        Comparator<Integer> comparator = Comparator.comparing(differences::get);
        TreeMap<Integer, Integer> sortedDifferences = new TreeMap<>(comparator.reversed());
        sortedDifferences.putAll(differences);
        pr.println(sortedDifferences.get(sortedDifferences.firstKey()));
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