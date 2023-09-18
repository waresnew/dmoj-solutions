import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 10/5/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class Maze {
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
        label:
        for (int test = readInt(); test > 0; test--) {
            int rows = readInt(), columns = readInt();
            char[][] grid = new char[rows][columns];
            for (int i = 0; i < rows; i++) {
                char[] input = readLine().toCharArray();
                for (int j = 0; j < columns; j++) {
                    grid[i][j] = input[j];
                }
            }
            ArrayDeque<Coordinate> queue = new ArrayDeque<>();
            queue.add(new Coordinate(0, 0));
            boolean[][] vis = new boolean[rows][columns];
            int[][] dis = new int[rows][columns];
            while (!queue.isEmpty()) {
                Coordinate cur = queue.poll();
                if (cur.x==rows-1 && cur.y==columns-1) {
                    pr.println(dis[cur.x][cur.y]+1);
                    continue label;
                }
                vis[cur.x][cur.y] = true;
                char c = grid[cur.x][cur.y];
                Coordinate[] nexts = new Coordinate[]{
                        new Coordinate(cur.x + 1, cur.y),
                        new Coordinate(cur.x - 1, cur.y),
                        new Coordinate(cur.x, cur.y + 1),
                        new Coordinate(cur.x, cur.y - 1)
                };
                if (c=='|') {
                    nexts[2] = null;
                    nexts[3] = null;
                }
                if (c=='-') {
                    nexts[0] = null;
                    nexts[1] = null;
                }
                for (Coordinate next : nexts) {
                    if (next == null) {
                        continue;
                    }

                    if (next.x >= rows || next.y >= columns || next.x<0||next.y<0) {
                        continue;
                    }
                    char c2 = grid[next.x][next.y];
                    if (c2=='*') {
                        continue;
                    }
                    if (!vis[next.x][next.y]) {
                        vis[next.x][next.y] = true;
                        queue.add(next);
                        dis[next.x][next.y] = dis[cur.x][cur.y]+1;
                    }

                }


            }
            pr.println(-1);
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