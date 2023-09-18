import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 11/18/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class BridgeTransport {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int maxWeight = readInt(), numberOfCars = readInt();
        int[] cars = new int[numberOfCars];
        for (int i = 0; i < numberOfCars; i++) {
            cars[i] = readInt();
        }
        int ans = 0;
        boolean[] done = new boolean[numberOfCars];
        label:
        for (int i = 0; i < numberOfCars; i++) {
            int weight = 0;
            for (int j = i; j < Math.min(numberOfCars, i + 4); j++) {
                weight+=cars[j];
                if (weight>maxWeight){
                    break label;
                }
                done[j]=true;
            }
        }
        for (boolean b : done) {
            ans += b?1:0;
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