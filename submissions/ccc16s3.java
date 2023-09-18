import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11/7/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class PhonomenalReviews {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;


    public static void main(String[] args) throws IOException {
        int n = readInt();
        boolean[] pho = new boolean[n];
        int start = -1;
        for (int i = readInt(); i > 0; i--) {
            int a = readInt();
            pho[a] = true;
            if (start==-1) {
                start=a;
            }
        }
        ArrayList<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = readInt(), b = readInt();
            tree[a].add(b);
            tree[b].add(a);
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (tree[i].size()==1) {
                queue.add(i);
                vis[i]=true;
            }
        }
        int edgeSum = n-1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (!pho[cur]) {
                for (int next : tree[cur]) {
                    if (!vis[next]&&tree[next].size()-1==1) {
                        vis[next]=true;
                        queue.add(next);
                    }
                }
                edgeSum--;
                tree[tree[cur].get(0)].remove(new Integer(cur));
                tree[cur].clear();
            }
        }
        int[] dis = new int[n];
        bfs(tree, dis, start);
        int endpoint1 = start;
        for (int i = 0; i < n; i++) {
            if (dis[i] > dis[endpoint1]) {
                endpoint1 = i;
            }
        }
        Arrays.fill(dis,0);
        bfs(tree, dis, endpoint1);
        int endpoint2 = 0;
        for (int i = 0; i < n; i++) {
            if (dis[i] > dis[endpoint2]) {
                endpoint2 = i;
            }
        }
        pr.println(2*edgeSum-dis[endpoint2]);
        pr.close();
    }


    private static void bfs(ArrayList<Integer>[] tree, int[] dis, int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : tree[cur]) {
                if (dis[next]==0&&next!=start) {
                    dis[next] = dis[cur] + 1;
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