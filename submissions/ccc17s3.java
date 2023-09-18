import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

//Template generated on 2022-02-10

public class NailedIt {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfWood = readInt();
        int[] piecesFreq = new int[2001];
        for (int i = 0; i < numberOfWood; i++) {
            piecesFreq[readInt()]++;
        }
        int maxLength = 0, heights = 0;
        for (int i = 2; i <= 4000; i++) {
            int boards = 0;
            for (int first = 1; first <= i/2; first++) {
                int second = i-first;
                if (second > 2000) {
                    continue;
                }
                if (first==second) {
                    boards += piecesFreq[first]/2;
                    continue;
                }
                boards += Math.min(piecesFreq[first], piecesFreq[second]);
            }
            if (boards > maxLength) {
                maxLength = boards;
                heights = 1;
            } else if (maxLength==boards) {
                heights++;
            }
        }
        pr.println(maxLength + " " + heights);
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