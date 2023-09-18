import java.io.*;
import java.util.*;

// 11/18/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class ItsToughBeingATeen {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        ArrayList<Integer>[] graph = new ArrayList[7 + 1];
        for (int i = 1; i <= 7; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[1].add(7);
        graph[1].add(4);
        graph[2].add(1);
        graph[3].add(4);
        graph[3].add(5);
        int a = -1, b = -1;
        int[] inDegree = new int[7 + 1];

        inDegree[1] = 1;
        inDegree[4] = 2;
        inDegree[5] = 1;
        inDegree[7] = 1;
        while (true) {
            int cur = readInt();
            if (a == -1) {
                a = cur;
            } else {
                b = cur;
            }
            if (a == 0 && b == 0) {
                break;
            } else if (a != -1 && b != -1) {
                graph[a].add(b);
                inDegree[b]++;
                a = -1;
                b = -1;
            }
        }
        for (int i = 1; i <= 7; i++) {
            Collections.sort(graph[i]);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= 7; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans.add(cur);
            for (int next : graph[cur]) {
                if (--inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        StringBuilder output = new StringBuilder();
        if (ans.size() == 7) {
            for (int i : ans) {
                output.append(i + " ");
            }
        }
        pr.println(ans.size() == 7 ? output.toString().trim() : "Cannot complete these tasks. Going to bed.");
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