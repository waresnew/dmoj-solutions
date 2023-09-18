import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2021-12-07

public class TheGreatVegetation {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Cow {

    }

    public static void main(String[] args) throws IOException {
        int numberOfPastures = readInt(), numberOfCows = readInt();
        int[] pastures = new int[numberOfPastures];
        @SuppressWarnings("unchecked")
        ArrayList<Cow>[] cows = new ArrayList[numberOfPastures];
        for (int i = 0; i < numberOfPastures; i++) {
            cows[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfCows; i++) {
            Cow cow = new Cow();
            cows[readInt() - 1].add(cow);
            cows[readInt() - 1].add(cow);
        }
        for (int i = 0; i < numberOfPastures; i++) {
            label:
            for (int j = 1; j <= 4; j++) {
                ArrayList<Cow> matchingCows = cows[i];
                for (int k = 0; k < i; k++) {
                    for (Cow cow1 : matchingCows) {
                        for (Cow cow2 : cows[k]) {
                            if (cow1 == cow2) {
                                if (pastures[k] == j) {
                                    continue label;
                                }
                            }
                        }
                    }

                }
                pastures[i] = j;
                break;
            }
            if (pastures[i] == 0) {
                throw new IllegalStateException("pasture " + i + " was not modified");
            }
        }
        pr.println(Arrays.toString(pastures).replace(" ", "").replace("[", "").replace("]", "").replace(",", ""));
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