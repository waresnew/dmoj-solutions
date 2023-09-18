import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 10/31/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class TombRobbing {
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
        int rows = readInt(), columns = readInt();
        char[][] grid = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            String line = readLine();
            for (int j = 0; j < columns; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        int ans = 0;
        boolean[][] vis = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] != 'X') {
                    if (!vis[i][j]) {
                        vis[i][j] = true;
                        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
                        queue.add(new Coordinate(i, j));
                        while (!queue.isEmpty()) {
                            Coordinate cur = queue.poll();

                            vis[cur.x][cur.y] = true;
                            Coordinate[] nexts = new Coordinate[]{
                                    new Coordinate(cur.x + 1, cur.y),
                                    new Coordinate(cur.x, cur.y + 1),
                                    new Coordinate(cur.x - 1, cur.y),
                                    new Coordinate(cur.x, cur.y - 1)
                            };
                            for (Coordinate next : nexts) {
                                if (next.x < 0 || next.y < 0 || next.x >= rows || next.y >= columns) {
                                    continue;
                                }
                                if (!vis[next.x][next.y] && grid[next.x][next.y] == '.') {
                                    vis[next.x][next.y] = true;
                                    queue.add(next);
                                }
                            }
                        }
                        ans++;
                    }
                }
            }
        }
        pr.println(ans);
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