import java.io.*;
import java.util.*;

// 10/25/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class JaydenStudiesTrees {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        int edges = readInt();
        ArrayList<Integer>[] tree = new ArrayList[edges + 1];
        for (int i = 1; i <= edges; i++) {
            tree[i] = new ArrayList<>();
        }
        int start = -1;
        for (int i = 0; i < edges-1; i++) {
            int a = readInt(), b = readInt();
            tree[a].add(b);
            tree[b].add(a);
            if (start == -1) {
                start = a;
            }
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[edges+1];
        vis[start] = true;
        queue.add(start);

        HashMap<Integer, Integer> depth = new HashMap<>();
        depth.put(start, 0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : tree[cur]) {
                if (!vis[next]) {
                    vis[next] = true;
                    depth.put(next, depth.get(cur)+1);
                    queue.add(next);
                }
            }
        }
        TreeMap<Integer, Integer> sorted = new TreeMap<>(Comparator.comparing(depth::get).reversed());
        sorted.putAll(depth);
        int deepest = sorted.firstKey();
        dfs(deepest, tree, new boolean[edges+1], new int[edges+1]);
        pr.println(ans);
        pr.close();
    }

    private static void dfs(int cur, ArrayList<Integer>[] tree, boolean[] vis, int[] dis) {
        vis[cur] = true;
        boolean flag = false;
        for (int next : tree[cur]) {
            if (!vis[next]) {
                flag = true;
                vis[next] = true;
                dis[next] = dis[cur] + 1;
                dfs(next, tree, vis, dis);
                vis[next] = false;
                dis[next] = 0;
            }
        }
        if (!flag) {
            ans = Math.max(ans, dis[cur]);
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