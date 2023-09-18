import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11/1/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class SaveNagato {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfPeople = readInt();
        ArrayList<Integer>[] tree = new ArrayList[numberOfPeople + 1];
        for (int i = 1; i <= numberOfPeople; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < numberOfPeople - 1; i++) {
            int a = readInt(), b = readInt();
            tree[a].add(b);
            tree[b].add(a);
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[numberOfPeople + 1];
        int[] dis = new int[numberOfPeople + 1];
        int endpoint1 = 0, endpoint2 = 0;
        queue.add(1); //arbitrary
        bfs(tree, queue, vis, dis);
        int maxDis = Integer.MIN_VALUE;
        for (int i = 1; i <= numberOfPeople; i++) {
            if (dis[i] > maxDis) {
                maxDis = dis[i];
                endpoint1 = i;
            }
        }
        maxDis = Integer.MIN_VALUE;
        Arrays.fill(vis, false);
        Arrays.fill(dis, 0);
        queue.add(endpoint1);
        bfs(tree, queue, vis, dis);
        for (int i = 1; i <= numberOfPeople; i++) {
            if (dis[i] > maxDis) {
                maxDis = dis[i];
                endpoint2 = i;
            }
        }
        int[] endDis1 = new int[numberOfPeople+1];
        System.arraycopy(dis, 0,endDis1,0,dis.length);
        int[] endDis2 = new int[numberOfPeople+1];
        Arrays.fill(vis, false);
        Arrays.fill(dis, 0);
        queue.add(endpoint2);
        bfs(tree, queue, vis, dis);
        System.arraycopy(dis, 0, endDis2,0,dis.length);
        for (int i = 1; i <= numberOfPeople; i++) {
            pr.println(Math.max(endDis1[i]+1, endDis2[i]+1));
        }
        pr.close();
    }

    private static void bfs(ArrayList<Integer>[] tree, ArrayDeque<Integer> queue, boolean[] vis, int[] dis) {
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            vis[cur] = true;
            for (int next : tree[cur]) {
                if (!vis[next]) {
                    vis[next] = true;
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