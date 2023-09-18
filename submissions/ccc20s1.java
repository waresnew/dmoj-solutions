import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 9/26/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class SurmisingASprintersSpeed {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static class Observation implements Comparable<Observation> {
        private final int time, distance;

        private Observation(int time, int distance) {
            this.time = time;
            this.distance = distance;
        }

        @Override
        public int compareTo(Observation o) {
            return Integer.compare(time, o.time);
        }
    }
    public static void main(String[] args) throws IOException {
        int numberOfObservations =readInt();
        Observation observations[] = new Observation[numberOfObservations];
        for (int i = 0; i < numberOfObservations; i++) {
            observations[i] = new Observation(readInt(), readInt());
        }
        Arrays.sort(observations);
        double ans = 0;
        for (int i = 0; i < numberOfObservations-1; i++) {
            Observation cur = observations[i], next = observations[i+1];
            ans = Math.max(ans, Math.abs(cur.distance- next.distance)/(double)(next.time- cur.time));
        }
        pr.println(ans);
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
        return bufferedReader.readLine();
    }
}