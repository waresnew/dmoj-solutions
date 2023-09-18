import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 10/5/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class RedistributingGifts {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfCows = readInt();
        int[][] cows = new int[numberOfCows + 1][numberOfCows + 1];
        for (int i = 1; i <= numberOfCows; i++) {
            for (int j = 1; j <= numberOfCows; j++) {
                cows[i][j] = readInt();
            }
        }
        ArrayList<Integer>[] graph = new ArrayList[numberOfCows + 1];
        for (int i = 1; i <= numberOfCows; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= numberOfCows; i++) {
            int cur = Integer.MAX_VALUE;
            for (int j = 1; j <= numberOfCows; j++) {
                if (cows[i][j] == i) {
                    cur = j;
                    break;
                }
            }

            for (int j = 1; j <= numberOfCows; j++) {
                if (j <= cur) {
                    graph[i].add(cows[i][j]);
                }
            }
        }
        boolean[][] reachable = new boolean[numberOfCows+1][numberOfCows+1];

        for (int i = 1; i <= numberOfCows; i++) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            stack.push(i);
            while (!stack.isEmpty()) {
                int cur = stack.pop();
                reachable[i][cur] = true;
                for (int next : graph[cur]) {
                    if (!reachable[i][next]) {
                        reachable[i][next] = true;
                        stack.push(next);
                    }
                }
            }
        }

        label:
        for (int i = 1; i <= numberOfCows; i++) {
            for (int next : cows[i]) {
                if (reachable[next][i]) {
                    pr.println(next);
                    continue label;
                }
            }
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