import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 10/17/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class DirectedAcyclicGraph {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (readInt()==1) {
                    graph[i].add(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (findCycle(graph, new boolean[n], i)) {
                pr.println("NO");
                pr.close();
                return;
            }
        }
        pr.println("YES");
        pr.close();


    }

    private static boolean findCycle(ArrayList<Integer>[] graph, boolean[] vis, int cur) {
        for (int next : graph[cur]) {
            if (vis[next]) {
                return true;
            } else {
                vis[next] = true;
                return findCycle(graph, vis, next);
            }
        }
        vis[cur] = false;
        return false;
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