import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

//Template generated on 4/13/2022

public class Traktor {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Coordinate {
        private final int x, y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfMushrooms = readInt(), target = readInt();
        Coordinate[] mushrooms = new Coordinate[numberOfMushrooms];
        for (int i = 0; i < numberOfMushrooms; i++) {
            mushrooms[i] = new Coordinate(readInt(), readInt());
        }
        HashMap<Integer, Integer> rows = new HashMap<>();
        HashMap<Integer, Integer> columns = new HashMap<>();
        HashMap<Integer, Integer> plusDiagonals = new HashMap<>();
        HashMap<Integer, Integer> minusDiagonals = new HashMap<>();

        int time = 0;
        for (Coordinate mushroom : mushrooms) {
            time++;
            rows.putIfAbsent(mushroom.y, 0);
            columns.putIfAbsent(mushroom.x, 0);
            minusDiagonals.putIfAbsent(mushroom.x - mushroom.y, 0);
            plusDiagonals.putIfAbsent(mushroom.y + mushroom.x, 0);
            rows.put(mushroom.y, rows.get(mushroom.y) + 1);
            columns.put(mushroom.x, columns.get(mushroom.x) + 1);
            minusDiagonals.put(mushroom.x - mushroom.y, minusDiagonals.get(mushroom.x - mushroom.y) + 1);
            plusDiagonals.put(mushroom.y + mushroom.x, plusDiagonals.get(mushroom.y + mushroom.x) + 1);

            if (rows.get(mushroom.y) == target || columns.get(mushroom.x) == target || minusDiagonals.get(mushroom.x - mushroom.y) == target || plusDiagonals.get(mushroom.y + mushroom.x) == target) {
                pr.println(time);
                pr.close();
                return;
            }
        }
        pr.println(-1);
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