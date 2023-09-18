import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2021-10-27

public class Spirals {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private enum Direction {
        LEFT("DOWN"),
        RIGHT("UP"),
        DOWN("RIGHT"),
        UP("LEFT");
        private final String next;

        Direction(String next) {
            this.next = next;
        }

        Direction next() {
            return Direction.valueOf(this.next);
        }
    }

    public static void main(String[] args) throws IOException {

        int[][] grid = new int[101][101];
        for (int[] row : grid) {
            Arrays.fill(row, -1);
        }
        int start = readInt();
        int end = readInt();
        //int[ycoord][xcoord]
        if (start == end) {
            pr.print(start);
            pr.close();
            return;
        } else if (start + 1 == end) {
            pr.println(start);
            pr.println(end);
            pr.close();
            return;
        }
        grid[50][50] = start;
        grid[51][50] = start + 1;
        grid[51][51] = start + 2;
        int length = 2;
        Direction direction = Direction.UP;
        int previousX = 51;
        int previousY = 51;
        int rotations = 0;
        label:
        for (int number = start + 3; number <= end; ) {
            for (int j = 0; j < length; j++) {
                switch (direction) {
                    case DOWN: {
                        grid[previousY + 1][previousX] = number;
                        previousY++;
                        break;
                    }
                    case LEFT: {
                        grid[previousY][previousX - 1] = number;
                        previousX--;
                        break;
                    }
                    case UP: {
                        grid[previousY - 1][previousX] = number;
                        previousY--;
                        break;
                    }
                    case RIGHT: {
                        grid[previousY][previousX + 1] = number;
                        previousX++;
                        break;
                    }
                }
                number++;
                if (number > end) {
                    break label;
                }
            }
            direction = direction.next();
            rotations++;
            if (rotations == 2) {
                rotations = 0;
                length++;
            }
        }
        for (int[] column : grid) {
            for (int element : column) {
                if (element != -1) {
                    pr.print(element + " ");
                }
            }
            pr.println();
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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}