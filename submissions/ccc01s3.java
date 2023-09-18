import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

// 10/15/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class StrategicBombing {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    private static HashSet<String> ans = new HashSet<>();
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        ArrayList<Integer>[] graph = new ArrayList[26];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        while (true) {
            String input = next();
            if (input.equals("**")) {
                break;
            }
            int a = input.charAt(0) - 65, b = input.charAt(1) - 65;
            graph[a].add(b);
            graph[b].add(a);
        }
        ArrayList<Integer> start = new ArrayList<>();
        start.add(0);
        dfs(graph, new boolean[26], 0, start, false);
        for (ArrayList<Integer> path : paths) {
            for (int i = 1; i < path.size(); i++) {
                graph[path.get(i)].remove(path.get(i-1));
                graph[path.get(i-1)].remove(path.get(i));
                flag = false;
                dfs(graph, new boolean[26], 0, new ArrayList<>(), true);
                if (!flag) {
                    ans.add((char)(path.get(i)+65)+""+(char)(path.get(i-1)+65));
                }
                graph[path.get(i)].add(path.get(i-1));
                graph[path.get(i-1)].add(path.get(i));
            }
        }

        ans.forEach(pr::println);
        pr.printf("There are %d disconnecting roads.", ans.size()).println();
        pr.close();

    }

    private static void dfs(ArrayList<Integer>[] graph, boolean[] vis, int cur, ArrayList<Integer> path, boolean second) {
        if (cur == 1) {
            if (second) {
               flag = true;
            } else {
                paths.add(new ArrayList<>(path));
            }
            return;
        }
        vis[cur] = true;
        for (int next : graph[cur]) {
            if (!vis[next]) {
                vis[next] = true;
                path.add(next);
                dfs(graph, vis, next, path, second);
                vis[next] = false;
                path.remove(path.size() - 1);
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