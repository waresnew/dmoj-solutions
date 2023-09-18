import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

// 10/5/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class GiantAnts {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int vertices= readInt(), edges = readInt();
        ArrayList<Integer>[] grid = new ArrayList[vertices+1];
        for (int i = 1; i <= vertices; i++) {
            grid[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges; i++) {
            int x = readInt(), y= readInt();
            grid[x].add(y);
            grid[y].add(x);
        }
        int numberOfAnts = readInt();
        HashSet<Integer> infested = new HashSet<>();
        for (int i = 0; i < numberOfAnts; i++) {
            infested.add(readInt());
        }

        boolean[] vis = new boolean[vertices+1];
        int[] dis = new int[vertices+1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            vis[cur] = true;
            for (int adj : grid[cur]) {
                if (!vis[adj] && !infested.contains(adj)) {
                    vis[adj] = true;
                    queue.add(adj);
                    dis[adj] = dis[cur]+1;
                }
            }
            if (++count%4==0) {
                ArrayList<Integer> toAdd = new ArrayList<>();
                for (int infest : infested) {
                    toAdd.addAll(grid[infest]);
                }
                infested.addAll(toAdd);
            }
        }
        if (vis[vertices]) {
            pr.println(dis[vertices]);
        } else {
            pr.println("sacrifice bobhob314");
        }
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