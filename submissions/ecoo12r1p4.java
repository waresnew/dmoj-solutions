import java.io.*;
import java.util.*;

//Template generated on 4/19/2022

@SuppressWarnings("DuplicatedCode")
public class Boggled {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static final String[][] grid = new String[4][4];

    private static class Coordinate {
        private final int row, column;

        private Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return row == that.row && column == that.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
        @Override
        public String toString() {
            return row + " " + column;
        }
    }

    private static class Snapshot {
        private ArrayList<Coordinate> path = new ArrayList<>();
        private HashSet<Coordinate> vis = new HashSet<>();

        private Snapshot(ArrayList<Coordinate> path, HashSet<Coordinate> vis) {
            this.path = path;
            this.vis = vis;
        }

        private Snapshot() {

        }
    }

    public static void main(String[] args) throws IOException {
        for (int test = 0; test < 5; test++) {
            for (int i = 0; i < 4; i++) {
                String[] row = readLine().split("");
                for (int j = 0; j < 4; j++) {
                    grid[i][j] = row[j];
                }
            }
            int numberOfWords = readInt();
            String[] words = new String[numberOfWords];
            HashSet<String> used = new HashSet<>();
            for (int i = 0; i < numberOfWords; i++) {
                words[i] = readLine();
            }
            int score = 0, good = 0, wrong = 0, tooShort = 0, repeated = 0;
            label:
            for (String word : words) {
                if (word.length() < 3) {
                    tooShort++;
                    continue;
                }
                if (used.contains(word)) {
                    repeated++;
                    continue;
                }
                used.add(word);
                ArrayDeque<Snapshot> stack = new ArrayDeque<>();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (grid[i][j].equals(String.valueOf(word.charAt(0)))) {
                            Snapshot snapshot = new Snapshot();
                            Coordinate c = new Coordinate(i, j);
                            snapshot.path.add(c);
                            snapshot.vis.add(c);
                            stack.push(snapshot);
                        }
                    }
                }
                while (!stack.isEmpty()) {
                    Snapshot snapshot = stack.pop();
                    if (snapshot.path.size() == word.length()) {
                        good++;
                        if (word.length() == 3 || word.length() == 4) {
                            score++;
                        } else if (word.length() == 5) {
                            score += 2;
                        } else if (word.length() == 6) {
                            score += 3;
                        } else if (word.length() == 7) {
                            score += 4;
                        } else {
                            score += 11;
                        }
                        continue label;
                    }
                    Coordinate head = snapshot.path.get(snapshot.path.size() - 1);
                    String target = String.valueOf(word.charAt(snapshot.path.size()));
                    Coordinate[] potential = new Coordinate[]{
                            new Coordinate(head.row + 1, head.column), //south
                            new Coordinate(head.row - 1, head.column), //north
                            new Coordinate(head.row, head.column + 1), //east
                            new Coordinate(head.row, head.column - 1),//west
                            new Coordinate(head.row + 1, head.column + 1), //southeast
                            new Coordinate(head.row - 1, head.column - 1), //northwest
                            new Coordinate(head.row - 1, head.column + 1), //southeast
                            new Coordinate(head.row + 1, head.column - 1) //southwest
                    };
                    for (Coordinate c : potential) {
                        if (!isValid(c.row, c.column)) {
                            continue;
                        }
                        if (snapshot.vis.contains(c)) {
                            continue;
                        }
                        if (grid[c.row][c.column].equals(target)) {
                            ArrayList<Coordinate> copy = new ArrayList<>(snapshot.path);
                            copy.add(new Coordinate(c.row, c.column));
                            Snapshot newSnapshot = new Snapshot(copy, new HashSet<>(snapshot.vis));
                            newSnapshot.vis.add(c);
                            stack.push(newSnapshot);
                        }
                    }
                }
                wrong++;
            }
            pr.printf("Your score: %d (%d good, %d not found, %d too short, %d repeated)", score, good, wrong, tooShort, repeated).println();
        }
        pr.close();
    }

    private static boolean isValid(int i, int j) {
        try {
            String a = grid[i][j];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
        return true;
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