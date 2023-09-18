import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 11/10/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class Politicari {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        long k = readLong();
        int[][] graph = new int[n + 1][n + 1]; //graph[cur][prev] -> next
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = readInt();
            }
        }
        graph[1][0] = 2;
        if (k == 2) {
            pr.println(2);
            pr.close();
            return;
        }
        if (k == 1) {
            pr.println(1);
            pr.close();
            return;
        }
        boolean[][] vis = new boolean[n + 1][n + 1];
        int[][] dis = new int[n + 1][n + 1];
        int cycleStart = 0, cycleEnd, cycleEndDis, cycleStartDis, cycleEndPrev, cycleStartPrev = 0;
        vis[1][0] = true;
        int cur = 1, prev = 0;
        while (true) {
            int next = graph[cur][prev], next2 = graph[next][cur];
            if (vis[next2][next]) {
                cycleEnd = cur;
                cycleEndPrev = prev;
                cycleStart = next;
                cycleStartPrev = cycleEnd;
                cycleStartDis = dis[cur][prev] + 1;
                int cur2 = cycleEnd, prev2 = cycleEndPrev;
                int[][] newDis = new int[n + 1][n + 1];
                newDis[cycleEnd][cycleEndPrev] = dis[cycleEnd][cycleEndPrev];
                while (true) {
                    int next3 = graph[cur2][prev2];
                    if (next3 == cycleEnd && cur2 == cycleEndPrev) {
                        cycleEndDis = newDis[cur2][prev2] + 1;
                        break;
                    } else {
                        vis[next3][cur2] = true;
                        newDis[next3][cur2] = newDis[cur2][prev2] + 1;
                        prev2 = cur2;
                        cur2 = next3;
                    }
                }
                break;
            } else {
                vis[next][cur] = true;
                dis[next][cur] = dis[cur][prev] + 1;
                prev = cur;
                cur = next;
            }
        }

        int ans = 1;
        if (k <= cycleEndDis) {
            int prev1 = 0;
            for (int i = 1; i < k; i++) {
                int copy = ans;
                ans = graph[ans][prev1];
                prev1 = copy;
            }
        } else {
            k -= cycleStartDis;
            ans = cycleEnd;
            k %= cycleEndDis - cycleStartDis + 1;
            int prev1 = cycleEndPrev;
            for (int i = 0; i < k; i++) {
                int copy = ans;
                ans = graph[ans][prev1];
                prev1 = copy;
            }
        }
        pr.println(ans);
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