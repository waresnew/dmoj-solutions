import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2021-10-27

public class ComputingTournament {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Player implements Comparable<Player> {
        private final int roundOne;
        private final int roundTwo;
        private final int index;

        private Player(int roundOne, int roundTwo, int index) {
            this.roundOne = roundOne;
            this.roundTwo = roundTwo;
            this.index = index;
        }

        @Override
        public int compareTo(Player o) {
            return Integer.compare(o.roundOne, roundOne);
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfPlayers = readInt();
        int numberToAdvance = readInt();
        Player[] players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player(readInt(), readInt(), i + 1);
        }
        Arrays.sort(players);
        Player highestPlayer = new Player(0, 0, 0);
        for (int i = 0; i < numberToAdvance; i++) {
            Player player = players[i];
            if (player.roundTwo > highestPlayer.roundTwo) {
                highestPlayer = player;
            }
        }
        pr.println(highestPlayer.index);
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