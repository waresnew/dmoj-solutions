import java.io.*;
import java.util.StringTokenizer;



public class PrefixSum {
    static class Query {
        int a;
        final int b;

        Query(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] trees = new int[n];
        for (int i = 0; i < trees.length; i++) {
            trees[i] = readInt();
        }
        int q = readInt();
        Query[] queries = new Query[q];
        for (int i = 0; i < queries.length; i++) {
            queries[i] = new Query(readInt(), readInt());
        }
        int counter = 0;
        int[] prefix = new int[trees.length];
        for (int i = 0; i < trees.length; i++) {
            counter += trees[i];
            prefix[i] = counter;
        }
        for (Query query : queries) {
            if (query.a == 0) {
                printer.println(prefix[query.b]);
            } else {
                printer.println(prefix[query.b] - prefix[query.a - 1]);
            }
        }
        printer.close();
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