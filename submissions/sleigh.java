import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

// 11/1/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class SleighRide {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Edge {
        private final int val, dis;

        private Edge(int val, int dis) {
            this.val = val;
            this.dis = dis;
        }

        @Override
        public String toString() {
            return val + " " + dis;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return val == edge.val && dis == edge.dis;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, dis);
        }
    }

    public static void main(String[] args) throws IOException {
        int n = readInt();
        ArrayList<Edge>[] tree = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a= readInt(), b= readInt(), c=readInt();
            tree[a].add(new Edge(b, c));
            tree[b].add(new Edge(a, c));
            sum += c;
        }
        boolean[] vis = new boolean[n+1];
        vis[0]=true;
        int[] dis = new int[n+1];
        ArrayDeque<Edge> queue = new ArrayDeque<>();
        queue.add(new Edge(0, 0));
        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            for (Edge next : tree[cur.val]) {
                if (!vis[next.val]) {
                    vis[next.val]=true;
                    dis[next.val]=dis[cur.val]+next.dis;
                    queue.add(next);
                }
            }
        }
        int longestDistance = Integer.MIN_VALUE;
        for (int d : dis) {
            longestDistance=Math.max(d, longestDistance);
        }
        pr.println(2*sum-longestDistance);
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