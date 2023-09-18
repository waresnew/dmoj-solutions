import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Rectangles {

    static class Coordinate {
        final int x;
        final int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return this.x * this.y;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Coordinate) {
                return this.x == ((Coordinate) o).x && this.y == ((Coordinate) o).y;
            } else {
                return false;
            }
        }
    }

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {

        int total = readInt();
        int[] xs = new int[total];
        int[] ys = new int[total];
        HashSet<Coordinate> coordinates = new HashSet<>(total);
        int area = 0;
        for (int i = 0; i < total; i++) {
            int x = readInt();
            int y = readInt();
            xs[i] = x;
            ys[i] = y;
            coordinates.add(new Coordinate(x, y));
        }

        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                if (coordinates.contains(new Coordinate(xs[i], ys[j])) && coordinates.contains(new Coordinate(xs[j], ys[i]))) {
                    area = Math.max(area, Math.abs(xs[i] - xs[j]) * Math.abs(ys[i] - ys[j]));
                }
            }
        }
        printer.println(area);
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