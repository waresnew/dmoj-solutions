import java.io.*;
import java.util.*;

// 10/17/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class PyramidMessageScheme {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static int time = 0;
    public static void main(String[] args) throws IOException {
        for (int list = readInt(); list > 0; list--) {
            int numberOfPeople = readInt();
            HashMap<String, ArrayList<String>> graph = new HashMap<>();
            String[] steps = new String[numberOfPeople];
            for (int i = 0; i < numberOfPeople; i++) {
               steps[i] = readLine();
            }

            String prev = null;
            String first = null;
            for (String cur : steps) {
                if (first == null) {
                    first = cur;
                    graph.putIfAbsent(steps[steps.length-1], new ArrayList<>());
                    graph.get(steps[steps.length-1]).add(first);
                }
                graph.putIfAbsent(cur, new ArrayList<>());
                if (prev != null) {
                    if (!graph.get(cur).contains(prev)) {
                        graph.get(prev).add(cur);
                    }
                }
                prev = cur;
            }
            dfs(graph, new HashSet<>(), steps[steps.length-1]);
            ArrayDeque<String> queue = new ArrayDeque<>();
            HashSet<String> vis = new HashSet<>();
            queue.add(steps[steps.length-1]);
            HashMap<String, Integer> heights = new HashMap<>();
            heights.put(steps[steps.length-1], 0);
            while (!queue.isEmpty()) {
                String cur = queue.poll();
                vis.add(cur);
                for (String next : graph.get(cur)) {
                    if (!vis.contains(next)) {
                        heights.put(next, heights.get(cur)+1);
                        vis.add(next);
                        queue.add(next);
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            for (int v : heights.values()) {
                max = Math.max(v, max);
            }
            pr.println(numberOfPeople*10-max*20);
            time=0;
        }
        pr.close();
    }

    private static void dfs(HashMap<String, ArrayList<String>> graph, HashSet<String> vis, String cur) {
        for (String next : graph.get(cur)) {
            if (!vis.contains(next)) {
                vis.add(next);
                time += 10; //responding
                dfs(graph, vis, next);
                vis.remove(next);
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