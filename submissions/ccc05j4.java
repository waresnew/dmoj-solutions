import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-11-17

public class CrossSpiral {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static boolean[][] grid;

    private enum Direction {
        LEFT(0, -1, "DOWN", "LEFT", "UP"),
        RIGHT(0, 1, "UP", "RIGHT", "DOWN"),
        DOWN(1, 0, "RIGHT", "DOWN", "LEFT"),
        UP(-1, 0, "LEFT", "UP", "RIGHT");
        private final int rowOffset;
        private final int columnOffset;
        private final String first;
        private final String second;
        private final String third;

        Direction(int rowOffset, int columnOffset, String first, String second, String third) {
            this.rowOffset = rowOffset;
            this.columnOffset = columnOffset;
            this.first = first;
            this.second = second;
            this.third = third;
        }

        private Direction getFirst() {
            return valueOf(first);
        }

        private Direction getSecond() {
            return valueOf(second);
        }

        private Direction getThird() {
            return valueOf(third);
        }
    }


    public static void main(String[] args) throws IOException {
        int mainHeight = readInt();
        int mainWidth = readInt();
        int cutHeight = readInt();
        int cutWidth = readInt();
        int totalSteps = readInt();
        grid = new boolean[mainWidth][mainHeight];
        //cutting top left
        for (int i = 0; i < cutWidth; i++) {
            for (int j = 0; j < cutHeight; j++) {
                grid[i][j] = true;
            }
        }
        //cutting bottom left
        for (int i = mainWidth - cutWidth; i < mainWidth; i++) {
            for (int j = 0; j < cutHeight; j++) {
                grid[i][j] = true;
            }
        }

        //cutting top right
        for (int i = 0; i < cutWidth; i++) {
            for (int j = mainHeight - cutHeight; j < mainHeight; j++) {
                grid[i][j] = true;
            }
        }

        //cutting bottom right
        for (int i = mainWidth - cutWidth; i < mainWidth; i++) {
            for (int j = mainHeight - cutHeight; j < mainHeight; j++) {
                grid[i][j] = true;
            }
        }
        int column = cutHeight;
        int row = 0;
        Direction direction = Direction.RIGHT;
        for (int i = 0; i < totalSteps; i++) {
            grid[row][column] = true;
            if (isValid(row + direction.getFirst().rowOffset, column + direction.getFirst().columnOffset)) {
                direction = direction.getFirst();
                row += direction.rowOffset;
                column += direction.columnOffset;
            } else if (isValid(row + direction.getSecond().rowOffset, column + direction.getSecond().columnOffset)) {
                direction = direction.getSecond();
                row += direction.rowOffset;
                column += direction.columnOffset;
            } else if (isValid(row + direction.getThird().rowOffset, column + direction.getThird().columnOffset)) {
                direction = direction.getThird();
                row += direction.rowOffset;
                column += direction.columnOffset;
            } else {
                break;
            }


        }
        pr.println(column + 1);
        pr.println(row + 1);
        pr.close();
    }

    private static boolean isValid(int row, int column) {
        try {
            return !grid[row][column];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}