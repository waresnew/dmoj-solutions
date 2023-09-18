import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-12-19

public class FarthestHiking {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int maxMinutes = readInt(), pathLength = readInt(), upSpeed = readInt(), flatSpeed = readInt(), downSpeed = readInt();
        char[] path = readLine().toCharArray();
        int[] forwardPsa = new int[path.length];
        int[] backPsa = new int[path.length];
        makePsa(downSpeed, flatSpeed, upSpeed, path, forwardPsa);
        makePsa(upSpeed, flatSpeed, downSpeed, path, backPsa);
        int answer = 0;
        for (int i = 0; i < pathLength; i++) {
            if (forwardPsa[i] + backPsa[i] <= maxMinutes) {
                answer = i + 1;
            }
        }
        pr.println(answer);
        pr.close();
    }

    private static void makePsa(int upSpeed, int flatSpeed, int downSpeed, char[] path, int[] backPsa) {
        for (int i = 0; i < path.length; i++) {
            if (i > 0) {
                backPsa[i] += backPsa[i - 1];
            }
            if (path[i] == 'u') {
                backPsa[i] += downSpeed;
            } else if (path[i] == 'f') {
                backPsa[i] += flatSpeed;
            } else if (path[i] == 'd') {
                backPsa[i] += upSpeed;
            }
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