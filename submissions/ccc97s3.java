import java.io.*;
import java.util.StringTokenizer;

//Template generated on 4/18/2022

public class DoubleKnockoutCompetition {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        for (int t = readInt(); t > 0; t--) {
            int numberOfTeams = readInt();
            long rounds = 0;
            int noLosses = numberOfTeams, oneLoss = 0, eliminated = 0;
            pr.printf("Round %d: %d undefeated, %d one-loss, %d eliminated", rounds, noLosses, oneLoss, eliminated).println();
            while (!(oneLoss == 1 && noLosses == 1)) {
                int noLossPlayers = noLosses / 2;
                int oneLossPlayers = oneLoss / 2;
                noLosses -= noLossPlayers;
                oneLoss += noLossPlayers;
                oneLoss -= oneLossPlayers;
                eliminated += oneLossPlayers;
                pr.printf("Round %d: %d undefeated, %d one-loss, %d eliminated", ++rounds, noLosses, oneLoss, eliminated).println();
            }
            pr.printf("Round %d: %d undefeated, %d one-loss, %d eliminated", ++rounds, --noLosses, ++oneLoss, eliminated).println();
            pr.printf("Round %d: %d undefeated, %d one-loss, %d eliminated", ++rounds, noLosses, --oneLoss, ++eliminated).println();
            pr.printf("There are %d rounds.", rounds).println();
            if (t != 1) {
                pr.println();
            }
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