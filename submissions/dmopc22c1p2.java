import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 10/24/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class HatSwap {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int students = readInt(), edges = readInt();
        int[] hats = new int[students + 1];
        for (int i = 1; i <= students; i++) {
            hats[i] = readInt();
        }
        if (hats[1] == hats[hats.length - 1]) {
            pr.println(0);
            pr.close();
            return;
        }
        ArrayList<Integer>[] graph = new ArrayList[students + 1];
        for (int i = 1; i <= students; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges; i++) {
            int a = readInt(), b = readInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        ArrayDeque<Integer> s = new ArrayDeque<>(), k = new ArrayDeque<>();
        boolean[] sVis = new boolean[students + 1], kVis = new boolean[students + 1];
        int[][] sHatVis = new int[students + 1][2], kHatVis = new int[students + 1][2];
        int[] sDis = new int[students + 1], kDis = new int[students + 1];
        sDis[0] = 1000000000;
        kDis[0] = 1000000000;
        sVis[1] = true;
        s.add(1);
        k.add(students);
        kVis[students] = true;
        sHatVis[hats[1]][0] = 1;
        kHatVis[hats[students]][0] = students;
        while (!s.isEmpty()) {
            bfs(s, sVis, sHatVis, graph, hats, sDis);
        }
        while (!k.isEmpty()) {
            bfs(k, kVis, kHatVis, graph, hats, kDis);
        }

        int ans = 1000000000;
        for (int hat = 1; hat <= students; hat++) {
            if (sHatVis[hat][0] == kHatVis[hat][0]) {
                int sum1 = sDis[sHatVis[hat][0]] + kDis[kHatVis[hat][1]];
                int sum2 = sDis[sHatVis[hat][1]] + kDis[kHatVis[hat][0]];
                ans = Math.min(ans, Math.min(sum1, sum2));
            } else {
                ans = Math.min(ans, sDis[sHatVis[hat][0]] + kDis[kHatVis[hat][0]]);
            }
        }
        pr.println(ans == 1000000000 ? -1 : ans);
        pr.close();

    }


    private static void bfs(ArrayDeque<Integer> queue, boolean[] vis, int[][] hatVis, ArrayList<Integer>[] graph, int[] hats, int[] dis) {
        int cur = queue.poll();
        vis[cur] = true;
        for (int next : graph[cur]) {
            if (!vis[next]) {
                vis[next] = true;
                dis[next] = dis[cur] + 1;
                int hat = hats[next];
                if (hatVis[hat][0] == 0) {
                    hatVis[hat][0] = next;
                } else if (hatVis[hat][1] == 0) {
                    hatVis[hat][1] = next;
                }
                queue.add(next);
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