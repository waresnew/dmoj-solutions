import java.io.*;
import java.util.*;

// 9/27/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class FloorPlan {
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

    public static void main(String[] args) throws IOException {
        int supply = readInt(), rows = readInt(), columns = readInt();
        ArrayList<Integer> rooms = new ArrayList<>();
        char[][] grid = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            char[] row = readLine().toCharArray();
            for (int j = 0; j < columns; j++) {
                grid[i][j] = row[j];
            }
        }
        boolean[][] vis = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!vis[i][j]) {
                    char cell = grid[i][j];
                    if (cell == '.') {
                        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
                        queue.add(new Coordinate(i, j));
                        HashSet<Coordinate> room = new HashSet<>();
                        while (!queue.isEmpty()) {
                            Coordinate cur = queue.poll();
                            room.add(cur);
                            vis[cur.x][cur.y] = true;
                            Coordinate[] adj = new Coordinate[]{
                                    new Coordinate(cur.x + 1, cur.y),
                                    new Coordinate(cur.x - 1, cur.y),
                                    new Coordinate(cur.x, cur.y + 1),
                                    new Coordinate(cur.x, cur.y - 1)
                            };
                            for (Coordinate next : adj) {
                                if (next.x >= rows || next.y >= columns || next.x < 0 || next.y < 0) {
                                    continue;
                                }
                                if (!vis[next.x][next.y] && grid[next.x][next.y]=='.') {
                                    queue.add(next);
                                }
                            }
                        }
                        rooms.add(room.size());
                    }
                }
            }
        }
        rooms.sort(Comparator.reverseOrder());
        int ans = 0;
        for (int room : rooms) {
            if (supply >= room) {
                supply -= room;
                ans++;
            } else {
                break;
            }
        }
        String stupid = ans !=1?"rooms":"room";
        pr.printf("%d %s, %d square metre(s) left over", ans,stupid, supply).println();
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