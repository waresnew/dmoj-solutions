import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

//Template generated on 4/13/2022

public class FreeShirts {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        for (int test = 0; test < 10; test++) {
            int numberOfShirts = readInt(), numberOfEvents = readInt(), numberOfDays = readInt(), ans = 0, clean = numberOfShirts;

            HashMap<Integer, Integer> events = new HashMap<>();
            for (int i = 0; i < numberOfEvents; i++) {
                int day = readInt();
                events.putIfAbsent(day, 0);
                events.put(day, events.get(day) + 1);
            }
            for (int i = 1; i <= numberOfDays; i++) {
                if (clean == 0) {
                    ans++;
                    clean = numberOfShirts;
                }
                clean--;
                if (events.containsKey(i)) {
                    clean += events.get(i);
                    numberOfShirts += events.get(i);
                }
            }
            pr.println(ans);
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