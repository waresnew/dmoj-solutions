import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//Template generated on 2022-02-04

public class TopYodeller {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfPeople = readInt(), numberOfRounds = readInt();
        int[] scores = new int[numberOfPeople];
        int[] ranks = new int[numberOfPeople];
        int[] worstRanks = new int[numberOfPeople];

        for (int i = 0; i < numberOfRounds; i++) {
            for (int j = 0; j < numberOfPeople; j++) {
                scores[j] += readInt();
            }
            for (int k = 1; k <= numberOfPeople; k++) {
                int numberOfHigherPeople = 0;
                for (int l = 1; l <= numberOfPeople; l++) {
                    if (scores[l - 1] > scores[k - 1]) {
                        numberOfHigherPeople++;
                    }
                }
                ranks[k - 1] = numberOfHigherPeople + 1;
                worstRanks[k - 1] = Math.max(worstRanks[k - 1], ranks[k - 1]);
            }
        }
        ArrayList<Integer> firstPlaceIndexes = new ArrayList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            if (ranks[i] == 1) {
                firstPlaceIndexes.add(i);
            }
        }

        Collections.sort(firstPlaceIndexes);
        for (int person : firstPlaceIndexes) {
            pr.println("Yodeller " + (person + 1) + " is the TopYodeller: score " + scores[person] + ", worst rank " + worstRanks[person]);
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