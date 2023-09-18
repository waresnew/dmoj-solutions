import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//Template generated on 2022-02-14

public class KnightHop {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Checkpoint {
        private final int row;
        private final int column;
        private final int steps;

        public Checkpoint(int row, int column) {
            this.row = row;
            this.column = column;
            steps = 0;
        }

        public Checkpoint(int row, int column, int steps) {
            this.row = row;
            this.column = column;
            this.steps = steps;
        }

        @Override
        public String toString() {
            return "Checkpoint{" +
                    "row=" + row +
                    ", column=" + column +
                    ", steps=" + steps +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        int currentColumn = readInt(), currentRow = readInt(), targetColumn = readInt(), targetRow = readInt();
        ArrayDeque<Checkpoint> queue = new ArrayDeque<>();
        queue.add(new Checkpoint(currentRow, currentColumn));
        while (!queue.isEmpty()) {
            Checkpoint checkpoint = queue.poll();
            if (checkpoint.row == targetRow && checkpoint.column == targetColumn) {
                pr.println(checkpoint.steps);
                pr.close();
                return;
            }
            Checkpoint[] next = new Checkpoint[]{
                    new Checkpoint(checkpoint.row - 1, checkpoint.column - 2, checkpoint.steps + 1),
                    new Checkpoint(checkpoint.row - 1, checkpoint.column + 2, checkpoint.steps + 1),
                    new Checkpoint(checkpoint.row + 1, checkpoint.column - 2, checkpoint.steps + 1),
                    new Checkpoint(checkpoint.row + 1, checkpoint.column + 2, checkpoint.steps + 1),
                    new Checkpoint(checkpoint.row - 2, checkpoint.column - 1, checkpoint.steps + 1),
                    new Checkpoint(checkpoint.row - 2, checkpoint.column + 1, checkpoint.steps + 1),
                    new Checkpoint(checkpoint.row + 2, checkpoint.column - 1, checkpoint.steps + 1),
                    new Checkpoint(checkpoint.row + 2, checkpoint.column + 1, checkpoint.steps + 1)
            };
            for (Checkpoint checkpoint1 : next) {
                if (checkpoint1.row <= 8 && checkpoint1.column <= 8 && checkpoint1.row >= 1 && checkpoint1.column >= 1) {
                    queue.add(checkpoint1);
                }
            }
        }
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