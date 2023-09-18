import java.io.*;
import java.util.*;

//Template generated on 4/13/2022

public class ChancesOfWinning {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static int answer = 0;

    private static class Game {
        private final int a, b;

        private Game(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Game game = (Game) o;
            return a == game.a && b == game.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }

    public static void main(String[] args) throws IOException {
        int target = readInt(), numberOfGames = readInt();
        HashMap<Integer, Integer> score = new HashMap<>();
        score.put(1, 0);
        score.put(2, 0);
        score.put(3, 0);
        score.put(4, 0);
        ArrayList<Game> games = new ArrayList<>();
        games.add(new Game(1, 2));
        games.add(new Game(1, 3));
        games.add(new Game(1, 4));
        games.add(new Game(2, 3));
        games.add(new Game(2, 4));
        games.add(new Game(3, 4));
        for (int i = 0; i < numberOfGames; i++) {
            int a = readInt(), b = readInt(), aScore = readInt(), bScore = readInt();
            games.remove(new Game(a, b));
            if (aScore == bScore) {
                score.put(a, score.get(a) + 1);
                score.put(b, score.get(b) + 1);
            } else if (aScore > bScore) {
                score.put(a, score.get(a) + 3);
            } else {
                score.put(b, score.get(b) + 3);
            }
        }
        game(score, games, target, 0);


        pr.println(answer);
        pr.close();
    }

    private static void game(HashMap<Integer, Integer> score, ArrayList<Game> games, int target, int index) {
        if (index == games.size()) {
            Comparator<Integer> comparator = (o1, o2) -> {
                int comp = score.get(o1).compareTo(score.get(o2));
                if (comp == 0) {
                    return 1;
                }
                return comp;
            };
            TreeMap<Integer, Integer> sorted = new TreeMap<>(comparator.reversed());
            sorted.putAll(score);
            int i = 0;
            boolean first = false;
            int topScore = 0;
            for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
                if (i == 0 && entry.getKey() == target) {
                    first = true;
                    topScore = entry.getValue();
                }
                if (first && i == 1 && entry.getValue() != topScore) {
                    answer++;
                    return;
                }
                i++;
            }
            return;
        }
        Game game = games.get(index);
        score.put(game.a, score.get(game.a) + 3);
        game(score, games, target, index + 1);
        score.put(game.a, score.get(game.a) - 3);

        score.put(game.b, score.get(game.b) + 3);
        game(score, games, target, index + 1);
        score.put(game.b, score.get(game.b) - 3);

        score.put(game.a, score.get(game.a) + 1);
        score.put(game.b, score.get(game.b) + 1);
        game(score, games, target, index + 1);
        score.put(game.a, score.get(game.a) - 1);
        score.put(game.b, score.get(game.b) - 1);

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