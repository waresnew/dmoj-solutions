import java.io.*;
import java.util.StringTokenizer;

class Coordinate {
    final int x;
    final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Triangles {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int totalPosts = readInt();
        int area = 0;
        Coordinate[] coordinates = new Coordinate[totalPosts];
        for (int i = 0; i < totalPosts; i++) {
            coordinates[i] = new Coordinate(readInt(), readInt());
        }
        for (Coordinate coordinate : coordinates) {
            for (Coordinate coordinate1 : coordinates) {
                for (Coordinate coordinate2 : coordinates) {
                    if (coordinate1.x == coordinate.x && coordinate.y == coordinate2.y) {
                        area = Math.max(area, Math.abs(coordinate.y - coordinate1.y) * Math.abs(coordinate.x - coordinate2.x));
                    }
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