import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 10/17/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class Friends {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static int ans = -1;

    public static void main(String[] args) throws IOException {
        int numberOfStudents = readInt();
        ArrayList<Integer>[] graph = new ArrayList[10000];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < numberOfStudents; i++) {
            graph[readInt()].add(readInt());
        }
        while (true) {
            int a = readInt(), b = readInt();
            if (a == 0 && b == 0) {
                break;
            }
            ans = -1;
            boolean[] vis = new boolean[10000];
            vis[a] = true;
            findCycle(graph, vis, a, new int[10000], a, b);
            if (ans == -1) {
                pr.println("No");
            } else {
                pr.println("Yes " + (ans - 1));
            }

        }
        pr.close();
    }

    private static void findCycle(ArrayList<Integer>[] graph, boolean[] vis, int cur, int[] dis, int start, int target) {
        for (int next : graph[cur]) {
            if (next == start) {
                if (vis[target]) {
                    ans = dis[target];
                    return;
                }
            }
            if (!vis[next]) {
                vis[next] = true;
                dis[next] = dis[cur] + 1;
                findCycle(graph, vis, next, dis, start, target);
                vis[next] = false;
                dis[next] = 0;
            }
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