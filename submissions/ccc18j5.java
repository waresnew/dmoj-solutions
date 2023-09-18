import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 9/19/2022

@SuppressWarnings({"DuplicatedCode", "unchecked"})
public class ChooseYourOwnPath {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfPages = readInt();
        ArrayList<Integer>[] pages = new ArrayList[numberOfPages+1];
        for (int i = 1; i <= numberOfPages; i++) {
            pages[i] = new ArrayList<>();
            for (int j = readInt(); j >0;j--) {
                pages[i].add(readInt());
            }
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        boolean[] vis = new boolean[numberOfPages+1];
        int[] dist = new int[numberOfPages+1];
        dist[1] = 1;
        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int page = queue.poll();
            vis[page]=true;
            if (pages[page].isEmpty()) {
                ans = Math.min(ans, dist[page]);
            }
            for (int next : pages[page]) {

                if (!vis[next]) {
                    queue.add(next);
                    dist[next]=Math.min(dist[next],dist[page]+1);
                    if (dist[next]==0) {
                        dist[next] = dist[page]+1;
                    }
                }
            }
        }
        boolean flag = false;
        for (int i = 1; i < vis.length;i++) {
            if (!vis[i]) {
                flag = true;
                break;
            }
        }
        pr.println(flag ? "N" : "Y");
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