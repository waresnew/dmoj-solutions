import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

// 9/27/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class AFK {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Coordinate {
        private final int x, y;
        private char value;

        private Coordinate(int x, int y, char value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws IOException {
        label:
        for (int test = readInt(); test > 0; test--) {
            int columns = readInt(), rows = readInt();
            char[][] grid = new char[rows][columns];
            Coordinate start = null;
            for (int i = 0; i < rows; i++) {
                char[] row = readLine().toCharArray();
                for (int j = 0; j < columns; j++) {
                    grid[i][j] = row[j];
                    if (row[j] == 'C') {
                        start = new Coordinate(i, j, row[j]);
                    }
                }
            }
            ArrayDeque<Coordinate> queue = new ArrayDeque<>();
            queue.add(start);
            int[][] dis = new int[rows][columns];
            dis[start.x][start.y] = 0;
            while (!queue.isEmpty()) {
                Coordinate cur = queue.poll();
                if (dis[cur.x][cur.y] >= 60) {
                    pr.println("#notworth");
                    continue label;
                }
                if (cur.value == 'W') {
                    pr.println(dis[cur.x][cur.y]);
                    continue label;
                }
                Coordinate[] adj = new Coordinate[]{
                        new Coordinate(cur.x + 1, cur.y, 'a'),
                        new Coordinate(cur.x - 1, cur.y, 'a'),
                        new Coordinate(cur.x, cur.y + 1, 'a'),
                        new Coordinate(cur.x, cur.y - 1, 'a')
                };
                for (Coordinate next : adj) {
                    if (next.x >= rows || next.y >= columns || next.x < 0 || next.y < 0) {
                        continue;
                    }
                    if (dis[next.x][next.y]==0) {
                        next.value = grid[next.x][next.y];
                        if (next.value != 'X') {
                            int dist = dis[next.x][next.y];
                            if (dist ==0) {
                                dis[next.x][next.y] = dis[cur.x][cur.y]+1;
                            }
                            dis[next.x][next.y] = Math.min(dis[cur.x][cur.y]+1, dis[next.x][next.y]);
                            queue.add(next);
                        }
                    }
                }
            }
            pr.println("#notworth");
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
        return bufferedReader.readLine();
    }
}