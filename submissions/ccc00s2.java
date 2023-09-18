import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Template generated on 2022-01-28

public class BabblingBrooksV2 {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;


    public static void main(String[] args) throws IOException {
        int numberOfStreams = readInt();
        ArrayList<Double> streams = new ArrayList<>();
        for (int i = 0; i < numberOfStreams; i++) {
            streams.add(readDouble());
        }
        while (true) {
            int mode = readInt();
            if (mode == 77) {
                break;
            } else if (mode == 99) {
                int target = readInt() - 1;
                double percentage = readDouble() / 100.0;
                double oldFlow = streams.get(target);
                streams.set(target, (1 - percentage) * oldFlow);
                streams.add(target, percentage * oldFlow);
            } else if (mode == 88) {
                int target = readInt() - 1;
                if (target < streams.size() - 1) {
                    streams.set(target, streams.get(target) + streams.get(target + 1));
                    streams.remove(target + 1);
                }
            }
        }
        for (double stream : streams) {
            pr.print((int) Math.round(stream) + " ");
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