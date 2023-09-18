import java.io.*;
import java.util.*;

// 10/5/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class TravellingSalesmen {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int cities = readInt();
        ArrayList<Integer>[] map = new ArrayList[cities+1];
        for (int i = 0; i <= cities; i++) {
            map[i] = new ArrayList<>();
        }
        int roads = readInt();
        for (int i = 0; i < roads; i++) {
            int a = readInt(), b= readInt();
            map[a].add(b);
            map[b].add(a);
        }
        int offices = readInt();
        HashSet<Integer> starts = new HashSet<>();
        for (int i = 0; i < offices; i++) {
            starts.add(readInt());
        }
        for (ArrayList<Integer> list :map) {
            list.removeAll(starts);
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>(starts);
        boolean[] vis = new boolean[cities+1];
        int[] dis = new int[cities+1];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            vis[cur] = true;
            for (int next : map[cur]) {
                if (!vis[next]) {
                    vis[next] = true;
                    dis[next] = dis[cur]+1;
                    queue.add(next);
                }
            }
        }
        Arrays.sort(dis);
        pr.println(dis[dis.length-1]);
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