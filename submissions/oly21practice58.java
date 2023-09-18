import java.io.*;
import java.util.StringTokenizer;

// 10/25/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class BobsPortalTravel {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static int cycleStart = -1, cycleLength = -1, end = -1;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        long k = readLong();
        int[] graph = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = readInt();
        }
        boolean[] vis = new boolean[n + 1];
        vis[1] = true;
        int[] dis = new int[n + 1];
        findCycle(graph, vis, 1, dis);
        if (end != -1) {
            pr.println(end);
            pr.close();
            return;
        }
        int cur;
        if (k < dis[cycleStart]) {
            cur = 1;
            for (int i = 0; i < k; i++) {
                cur = graph[cur];
            }

        } else {
            k -= dis[cycleStart];
            k %= cycleLength;
            cur = cycleStart;
            for (int i = 0; i < k; i++) {
                cur = graph[cur];
            }

        }
        pr.println(cur);
        pr.close();
    }

    private static void findCycle(int[] graph, boolean[] vis, int cur, int[] dis) {
        int next = graph[cur];
        if (vis[next]) {
            cycleStart = next;
            cycleLength = Math.abs(dis[next] - dis[cur]) + 1;
            return;
        }
        vis[next] = true;
        dis[next] = dis[cur] + 1;
        findCycle(graph, vis, next, dis);

        if (next == 0) {
            end = cur;
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
        return bufferedReader.readLine();
    }
}