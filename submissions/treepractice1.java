import java.io.*;
import java.util.*;

// 11/7/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class TreeTasks {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static class Edge {
        private final int val, weight;

        private Edge(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = readInt();
        ArrayList<Edge>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = readInt(), b = readInt(), c = readInt();
            tree[a].add(new Edge(b, c));
            tree[b].add(new Edge(a, c));
        }
        int[] dis = new int[n + 1],prev=new int[n+1];
        bfs(tree, dis, 1,prev);
        int endpoint1 = 1;
        for (int i = 1; i <= n; i++) {
            if (dis[i] > dis[endpoint1]) {
                endpoint1 = i;
            }
        }
        Arrays.fill(dis, 0);
        Arrays.fill(prev,0);
        bfs(tree, dis, endpoint1,prev);
        int endpoint2 = 1;
        for (int i = 1; i <= n; i++) {
            if (dis[i] > dis[endpoint2]) {
                endpoint2 = i;
            }
        }

        pr.println(dis[endpoint2]);
        int radius = Integer.MAX_VALUE;
        for (int i = endpoint2; i!=0; i=prev[i]) {

                radius = Math.min(radius, Math.max(dis[i], dis[endpoint2] - dis[i]));

        }
        pr.println(radius);
        pr.close();
    }

    private static void bfs(ArrayList<Edge>[] tree, int[] dis, int start,int[] prev) {
        ArrayDeque<Edge> queue = new ArrayDeque<>();
        queue.add(new Edge(start, -1));
        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            for (Edge next : tree[cur.val]) {
                if (next.val!=start&&dis[next.val] == 0) {
                    prev[next.val]= cur.val;
                    dis[next.val] = dis[cur.val] + next.weight;
                    queue.add(next);
                }
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