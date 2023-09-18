import java.io.*;
import java.util.StringTokenizer;

public class Origami {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        double piecesNeeded = readLong();
        double scissorStrength = readLong();
        /*
        2 phases
        1 = cutting at maximum speed (2x each time) until you hit scissorstrength
        2 = cutting at scissorstrength until you hit piecesneeded
         */
        if (piecesNeeded < scissorStrength) {
            printer.println(Math.round(Math.ceil(Math.log(piecesNeeded) / Math.log(2))));
            printer.close();
            return;
        }
        double cutsNeededForPhase1 = Math.ceil(Math.log(scissorStrength) / Math.log(2));
        printer.println(Math.round(Math.ceil((piecesNeeded - Math.pow(2, cutsNeededForPhase1)) / scissorStrength) + cutsNeededForPhase1));
        printer.close();

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