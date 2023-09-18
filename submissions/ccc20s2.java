import java.io.*;
import java.util.*;

// 9/26/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class EscapeRoomV2 {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Coordinate {
        private final int x, y, value;

        private Coordinate(int x, int y, int value) {
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
        int rows = readInt(), columns = readInt();
        ArrayList<Coordinate>[] factors = new ArrayList[(rows+1)*(columns+1)];
        int startValue = Integer.MAX_VALUE;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                int val = readInt();
                if (i == 1 && j == 1) {
                    startValue = val;
                }
                if (factors[i*j]==null) {
                    factors[i*j] = new ArrayList<>();
                }
                factors[i*j].add(new Coordinate(i, j, val));


            }
        }
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[rows+1][columns+1];

        queue.push(new Coordinate(1, 1, startValue));
        while (!queue.isEmpty()) {
            Coordinate cur = queue.pop();
            vis[cur.x][cur.y] = true;
            if (cur.x == rows && cur.y == columns) {
                pr.println("yes");
                pr.close();
                return;
            }
            if (cur.value>= factors.length) {
                continue;
            }
            ArrayList<Coordinate> adj = factors[cur.value];
            if (adj == null) {
                continue;
            }
            for (Coordinate next : adj) {
                if (!vis[next.x][next.y]) {
                    queue.push(next);
                }
            }
        }
        pr.println("no");
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