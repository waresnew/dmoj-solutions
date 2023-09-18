import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringTokenizer;

public class SquarePool {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Coordinate {
        private int row;
        private int column;

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

    public static void main(String[] args) throws IOException {
        int length = readInt();
        int numberOfTrees = readInt();
        Coordinate[] trees = new Coordinate[numberOfTrees + 2];
        for (int i = 0; i < numberOfTrees; i++) {
            int row = readInt(), column = readInt();
            trees[i] = new Coordinate(row, column);
        }
        trees[numberOfTrees] = new Coordinate(0, 0);
        trees[numberOfTrees + 1] = new Coordinate(length + 1, length + 1);
        int answer = 0;
        for (Coordinate left : trees) {
            for (Coordinate right : trees) {
                if (left == right || left.column > right.column) {
                    continue;
                }
                ArrayList<Coordinate> insideTrees = new ArrayList<>();
                for (Coordinate tree : trees) {
                    if (tree.column < right.column && tree.column > left.column) {
                        insideTrees.add(tree);
                    }
                }
                insideTrees.add(new Coordinate(0, 0));
                insideTrees.add(new Coordinate(length + 1, length + 1));
                int sideLength = Math.abs(left.column - right.column) - 1;

                Comparator<Coordinate> rowComparator = Comparator.comparingInt(o -> o.row);
                insideTrees.sort(rowComparator);
                for (int i = 0; i < insideTrees.size() - 1; i++) {
                    answer = Math.max(answer, Math.min(sideLength, Math.abs(insideTrees.get(i).row - insideTrees.get(i + 1).row) - 1));
                }
            }
        }

        pr.println(answer);
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
        return bufferedReader.readLine().trim();
    }
}