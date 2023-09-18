import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

//Template generated on 2021-11-07

public class ModeFinding {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfElements = readInt();
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < numberOfElements; i++) {
            int number = readInt();
            frequencies.putIfAbsent(number, 0);
            frequencies.put(number, frequencies.get(number) + 1);
        }
        Comparator<Integer> comparator = (o1, o2) -> {
            if (frequencies.get(o1).equals(frequencies.get(o2))) {
                return o2.compareTo(o1);
            }
            return frequencies.get(o1).compareTo(frequencies.get(o2));
        };
        TreeMap<Integer, Integer> sorted = new TreeMap<>(comparator.reversed());
        sorted.putAll(frequencies);
        pr.println(sorted.firstKey());
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