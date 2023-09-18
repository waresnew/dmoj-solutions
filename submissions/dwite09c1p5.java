import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 10/15/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class RunningInCircles {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static int ans = -1;

    public static void main(String[] args) throws IOException {
        label:
        for (int test = 0; test < 5; test++) {
            int n = readInt();
            ArrayList<Integer>[] graph = new ArrayList[101];
            for (int i = 1; i <= 100; i++) {
                graph[i] = new ArrayList<>();
            }
            int first = -1;
            for (int i = 0; i < n; i++) {
                int a = readInt(), b = readInt();
                if (a == b) {
                    pr.println(1);
                    continue label;
                }
                if (first == -1) {
                    first = a;
                }
                graph[a].add(b);
            }
            boolean[] vis = new boolean[101];
            vis[first] = true;

            findCycle(graph, vis, first, new int[101]);
            pr.println(ans);
        }
        pr.close();
    }

    private static void findCycle(ArrayList<Integer>[] graph, boolean[] vis, int cur, int[] dis) {
        for (int next : graph[cur]) {
            if (vis[next]) {
                ans=Math.abs(dis[next] - dis[cur]) + 1;
                return;
            }
            vis[next] = true;
            dis[next] = dis[cur] + 1;
            findCycle(graph, vis, next, dis);
            vis[next] = false;
            dis[next] = 0;
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