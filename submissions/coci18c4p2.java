import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 10/31/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class Wand {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfWizards = readInt(), numberOfDuels = readInt();
        ArrayList<Integer>[] graph = new ArrayList[numberOfWizards+1];
        for (int i = 1;i<=numberOfWizards;i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < numberOfDuels; i++) {
            int b = readInt(), a = readInt();
            graph[a].add(b);
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[numberOfWizards+1];
        queue.add(1);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (!vis[next]) {
                    vis[next] = true;
                    queue.add(next);
                }
            }
            if (graph[cur].isEmpty()) {
                vis[cur] = true;
            }
        }
        for (int i = 1; i <= numberOfWizards; i++) {
            pr.print(vis[i]?1:0);
        }
        pr.println();
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