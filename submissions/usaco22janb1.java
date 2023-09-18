import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class Herdle {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

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
    }

    public static void main(String[] args) throws IOException {
        char[][] correct = new char[3][3];
        HashMap<Character, Integer> correctCount = new HashMap<>();
        char[][] guess = new char[3][3];
        HashMap<Character, Integer> guessCount = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < 3; j++) {
                correct[i][j] = row.charAt(j);
                correctCount.putIfAbsent(row.charAt(j), 0);
                correctCount.put(row.charAt(j), correctCount.get(row.charAt(j)) + 1);
            }
        }
        for (int i = 0; i < 3; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < 3; j++) {
                guess[i][j] = row.charAt(j);
                guessCount.putIfAbsent(row.charAt(j), 0);
                guessCount.put(row.charAt(j), guessCount.get(row.charAt(j)) + 1);
            }
        }
        HashSet<Coordinate> greened = new HashSet<>();
        int green = 0, yellow = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (correct[i][j] == guess[i][j]) {
                    green++;
                    greened.add(new Coordinate(i, j));
                    correctCount.put(correct[i][j], correctCount.get(correct[i][j]) - 1);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (correctCount.get(guess[i][j]) != null && correctCount.get(guess[i][j]) > 0 && !greened.contains(new Coordinate(i, j))) {
                    yellow++;
                    correctCount.put(guess[i][j], correctCount.get(guess[i][j]) - 1);
                }
            }
        }
        pr.println(green);
        pr.println(yellow);
        pr.close();
    }

    private static String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine().trim());
        }
        return stringTokenizer.nextToken();
    }
}