import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2022-02-24

public class SnowboardingChampionship {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfObstacles = readInt(), andrewHeight = readInt(), tommyHeight = readInt();
        int[] andrew = new int[numberOfObstacles];
        int[] tommy = new int[numberOfObstacles];
        for (int i = 0; i < numberOfObstacles; i++) {
            andrew[i] = readInt();
            tommy[i] = readInt();
        }
        int andrewTime = 0, tommyTime = 0;
        for (int i = 0; i < numberOfObstacles; i++) {
            if (andrew[i] < andrewHeight) {
                andrewTime++;
            } else {
                andrewTime += 2;
            }
            if (tommy[i] < tommyHeight) {
                tommyTime++;
            } else {
                tommyTime += 2;
            }
        }
        if (andrewTime == tommyTime) {
            pr.println("Tie!");
            pr.close();
            return;
        }
        pr.println((andrewTime < tommyTime ? "Andrew" : "Tommy") + " wins!");
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