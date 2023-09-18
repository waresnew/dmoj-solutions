import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

// 11/18/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class ChristmasTreeBuilding {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static boolean[] vis;
    private static long[] dis;
    private static int[] prev;
    /*
    query 1: do a straight line from diameter endpoint
    query 2: attach centres
     */

    private static class Edge {
        private final int val, weight;

        private Edge(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return val + " " + weight;
        }
    }

    private static class Stat {
        private final long diameter, radius;

        private Stat(long diameter, long radius) {
            this.diameter = diameter;
            this.radius = radius;
        }
    }


    public static void main(String[] args) throws IOException {
        int vertices = readInt(), totalEdges = readInt(), query = readInt();
        ArrayList<Edge>[] tree = new ArrayList[vertices + 1];
        for (int i = 1; i <= vertices; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < totalEdges; i++) {
            int a = readInt(), b = readInt(), c = readInt();
            tree[a].add(new Edge(b, c));
            tree[b].add(new Edge(a, c));
        }
        dis = new long[vertices + 1];
        prev = new int[vertices + 1];
        long diameterSum = 0;
        int trees = 0;
        vis = new boolean[vertices + 1];
        long maxRadius = 0;
        HashMap<Long, Long> radiuses = new HashMap<>();
        for (int i = 1; i <= vertices; i++) {
            if (!vis[i]) {
                vis[i] = true;
                Stat stat = getStats(tree, i);
                diameterSum += stat.diameter;
                trees++;
                maxRadius = Math.max(maxRadius, stat.radius);
                radiuses.putIfAbsent(stat.radius, 0L);
                radiuses.put(stat.radius, radiuses.get(stat.radius) + 1);
            }
        }
        pr.println(query == 1 ? diameterSum + trees - 1 : (radiuses.get(maxRadius) > 1 ? maxRadius + 1 : maxRadius));
        pr.close();
    }

    private static Stat getStats(ArrayList<Edge>[] tree, int start) {
        int diameter1 = start, diameter2 = start;
        ArrayDeque<Edge> stack = new ArrayDeque<>();
        ArrayList<Integer> visited = new ArrayList<>();
        stack.push(new Edge(start, -1));
        vis[start] = true;
        visited.add(start);
        while (!stack.isEmpty()) {
            Edge cur = stack.pop();
            for (Edge next : tree[cur.val]) {
                if (!vis[next.val]) {
                    visited.add(next.val);
                    prev[next.val] = cur.val;
                    dis[next.val] = dis[cur.val] + next.weight;
                    vis[next.val] = true;
                    stack.push(next);
                }
            }
        }
        vis[start] = false;
        for (int v : visited) {
            if (dis[v] > dis[diameter1]) {
                diameter1 = v;
            }
        }
        for (int v : visited) {
            //cleanup
            prev[v] = 0;
            vis[v] = false;
            dis[v] = 0;
        }
        visited.clear();
        stack.push(new Edge(diameter1, -1));
        vis[diameter1] = true;
        visited.add(diameter1);
        while (!stack.isEmpty()) {
            Edge cur = stack.pop();
            for (Edge next : tree[cur.val]) {
                if (!vis[next.val]) {
                    visited.add(next.val);
                    prev[next.val] = cur.val;
                    dis[next.val] = dis[cur.val] + next.weight;
                    vis[next.val] = true;
                    stack.push(next);
                }
            }
        }
        for (int v : visited) {
            if (dis[v] > dis[diameter2]) {
                diameter2 = v;
            }
        }

        long radius = Long.MAX_VALUE;
        for (int i = diameter2; i != 0; i = prev[i]) {
            radius = Math.min(radius, Math.max(dis[i], dis[diameter2] - dis[i]));
        }

        return new Stat(dis[diameter2], radius);
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