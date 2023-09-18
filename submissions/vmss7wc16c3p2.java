import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 9/19/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class CanShahirEvenGetThere {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int vertices = readInt(), edges = readInt(), start = readInt(), end = readInt();
        ArrayList<Integer>[] roads = new ArrayList[vertices+1];
        for (int i = 1; i <= vertices; i++) {
            roads[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges; i++) {
            int x = readInt(), y = readInt();
            roads[x].add(y);
            roads[y].add(x);
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        boolean[] vis = new boolean[vertices + 1];
        while (!queue.isEmpty()) {
            int house = queue.poll();
            vis[house] = true;
            if (house == end) {
                pr.println("GO SHAHIR!");
                pr.close();
                return;
            }
            for (int next : roads[house]) {

                if (!vis[next]) {
                    queue.add(next);
                }
            }
        }
        pr.println("NO SHAHIR!");
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