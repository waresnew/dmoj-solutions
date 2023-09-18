import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

// 9/27/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class Oversleep {
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
    }

    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) throws IOException {
        int rows = readInt(), columns = readInt();
        char[][] grid = new char[rows][columns];
        Coordinate start = null;
        for (int i = 0; i < rows; i++) {
            char[] row = readLine().toCharArray();
            for (int j = 0; j < columns; j++) {
                grid[i][j] = row[j];
                if (row[j]=='s') {
                    start = new Coordinate(i, j, row[j]);
                }
            }
        }
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(start);
        boolean[][] vis = new boolean[rows][columns];
        HashMap<Coordinate, Integer> dis = new HashMap<>();
        dis.put(start, 0);
        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            vis[cur.x][cur.y] = true;
            if (cur.value=='e') {
                pr.println(dis.get(cur)-1);
                pr.close();
                return;
            }
            Coordinate[] adj = new Coordinate[]{
                    new Coordinate(cur.x+1, cur.y, 'a'),
                    new Coordinate(cur.x-1, cur.y, 'a'),
                    new Coordinate(cur.x, cur.y+1, 'a'),
                    new Coordinate(cur.x, cur.y-1, 'a')
            };
            for (Coordinate next : adj) {
                if (next.x >= rows || next.y >= columns || next.x<0||next.y<0) {
                    continue;
                }
                if (!vis[next.x][next.y]) {
                    next.value = grid[next.x][next.y];
                    if (next.value != 'X') {
                        dis.putIfAbsent(next, Integer.MAX_VALUE);
                        dis.put(next, Math.min(dis.get(next), dis.get(cur)+1));
                        queue.add(next);
                    }
                }
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
        return bufferedReader.readLine();
    }
}