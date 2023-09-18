import java.io.*;
import java.util.StringTokenizer;

//Template generated on 3/14/2022

public class NormalProbabilities {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfEvents = readInt();
        String[] events = new String[numberOfEvents];
        for (int i = 0; i < numberOfEvents; i++) {
            events[i] = readLine();
        }
        double answer = 1;
        for (int i = 0; i < events.length; i++) {
            switch (events[i]) {
                case "A": {
                    answer *= 1;
                    break;
                }
                case "B": {
                    answer *= 0.8;
                    break;
                }
                case "C": {
                    answer *= 0.6;
                    break;
                }
                case "D": {
                    answer *= 0.4;
                    break;
                }
                case "E": {
                    answer *= 0.2;
                    break;
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