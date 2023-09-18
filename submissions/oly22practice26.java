import java.io.*;
import java.util.*;

//Template generated on 4/5/2022

public class ColourfulMarbles {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfMarbles = readInt(), maxColours = readInt();
        int[] marbles = new int[numberOfMarbles];
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < numberOfMarbles; i++) {
            marbles[i] = readInt();
            freq.putIfAbsent(marbles[i], 0);
            freq.put(marbles[i], freq.get(marbles[i])+1);
        }
        Comparator<Integer> comparator = (o1, o2) -> {
            int comp = freq.get(o1).compareTo(freq.get(o2));
            if (comp == 0) {
                return 1;
            }
            return comp;
        };
        TreeMap<Integer, Integer> sorted = new TreeMap<>(comparator.reversed());
        sorted.putAll(freq);
        ArrayList<Integer> order = new ArrayList<>(sorted.keySet());
        sorted = null;
        int answer = 0;
        while (order.size() > maxColours) {
            int leastColour = order.get(order.size()-1);
            freq.put(leastColour, freq.get(leastColour)-1);
            if (freq.get(leastColour) == 0) {
                order.remove(order.size()-1);
            }
            answer++;
        }
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