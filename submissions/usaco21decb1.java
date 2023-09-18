import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Template generated on 2022-01-09

public class LonelyPhotoFixed {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static long answer = 0;
    private static int numberOfCows;

    public static void main(String[] args) throws IOException {
        numberOfCows = readInt();
        String cows = readLine();
        ArrayList<Integer> gIndexes = new ArrayList<>();
        ArrayList<Integer> hIndexes = new ArrayList<>();
        gIndexes.add(0);
        hIndexes.add(0);
        for (int i = 1; i <= numberOfCows; i++) {
            if (cows.charAt(i - 1) == 'G') {
                gIndexes.add(i);
            } else if (cows.charAt(i - 1) == 'H') {
                hIndexes.add(i);
            }
        }
        gIndexes.add(numberOfCows + 1);
        hIndexes.add(numberOfCows + 1);
        getLonelyPhotos(gIndexes);
        getLonelyPhotos(hIndexes);
        pr.println(answer);
        pr.close();

    }

    private static void getLonelyPhotos(ArrayList<Integer> targetIndexes) {
        for (int i = 1; i < targetIndexes.size() - 1; i++) {
            int left = targetIndexes.get(i) - targetIndexes.get(i - 1);
            int right = targetIndexes.get(i + 1) - targetIndexes.get(i);
            if (right > 1) {
                answer--;
            }
            if (left > 1) {
                answer--;
            }
            answer += (long) right * left - 1;
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