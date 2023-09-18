import java.io.*;
import java.util.*;

//Template generated on 2021-11-01

public class ConditionalContracts {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfActors = readInt();
        //most frequent 2 numbers
        HashMap<Integer, Integer> actors = new HashMap<>();
        for (int i = 0; i < numberOfActors; i++) {
            int required = readInt();
            actors.putIfAbsent(required, 0);
            actors.put(required, actors.get(required) + 1);
        }
        Comparator<Integer> sortByValue = (o1, o2) -> {
            int comparison = actors.get(o1).compareTo(actors.get(o2));
            if (comparison == 0) {
                return o1.compareTo(o2);
            } else {
                return comparison;
            }
        };
        TreeMap<Integer, Integer> sorted = new TreeMap<>(sortByValue.reversed());
        sorted.putAll(actors);
        int first = sorted.pollFirstEntry().getValue();
        Map.Entry<Integer, Integer> second = sorted.pollFirstEntry();

        if (second == null) {
            pr.println(first);
            pr.close();
            return;
        }
        pr.println(first + second.getValue());
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