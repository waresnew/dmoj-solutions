import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 9/19/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class CatchTheCat {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        int start = readInt(), end = readInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        boolean[] vis = new boolean[100001];
        int[] dis = new int[100001];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            vis[cur] = true;
            if (cur == end) {
                pr.println(dis[cur]);
                pr.close();
                return;
            }
            int[] nexts = new int[3];
            nexts[0] = cur + 1;
            nexts[1] = cur - 1;
            nexts[2] = 2 * cur;
            for (int next : nexts) {
                if (next > 100000 || next < 0) {
                    continue;
                }
                if (!vis[next]) {
                    queue.add(next);
                    dis[next] = Math.min(dis[next], dis[cur] + 1);
                    if (dis[next] == 0) {
                        dis[next] = dis[cur] + 1;
                    }
                }
            }
        }
        throw new Exception();

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