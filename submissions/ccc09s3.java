import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

// 9/12/2022

@SuppressWarnings("DuplicatedCode")
public class DegreesOfSeparation {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        @SuppressWarnings("unchecked")
        HashSet<Integer>[] network = new HashSet[50];
        for (int i = 1; i < 50; i++) {
            network[i] = new HashSet<>();
        }
        add(network[1], 6);
        add(network[2], 6);
        add(network[3], 4, 5, 6, 15);
        add(network[4], 3, 5, 6);
        add(network[5], 6, 4, 3);
        add(network[6], 1, 2, 3, 4, 5, 7);
        add(network[7], 6, 8);
        add(network[8], 7, 9);
        add(network[9], 8, 10, 12);
        add(network[10], 9, 11);
        add(network[11], 10, 12);
        add(network[12], 9, 11, 13);
        add(network[13], 12, 15, 14);
        add(network[14], 13);
        add(network[15], 3, 13);
        add(network[16], 18, 17);
        add(network[17], 16, 18);
        add(network[18], 16, 17);
        while (true) {
            String input = next();
            if (input.equals("i")) {
                int x = readInt(), y = readInt();
                network[x].add(y);
                network[y].add(x);
            } else if (input.equals("d")) {
                int x = readInt(), y = readInt();
                network[x].remove(y);
                network[y].remove(x);
            } else if (input.equals("n")) {
                pr.println(network[readInt()].size());
            } else if (input.equals("f")) {
                HashSet<Integer> ans = new HashSet<>();
                int x = readInt();
                for (int friend : network[x]) {
                    ans.addAll(network[friend]);
                }
                ans.remove(x);
                network[x].forEach(ans::remove);
                pr.println(ans.size());
            } else if (input.equals("s")) {
                degree(network, readInt(), readInt(), new HashSet<>(), 0);
                if (answer == Integer.MAX_VALUE) {
                    pr.println("Not connected");
                } else {
                    pr.println(answer);
                }
                answer = Integer.MAX_VALUE;
            } else if (input.equals("q")) {
                pr.close();
                break;
            }
        }
    }

    private static void add(HashSet<Integer> list, int... nums) {
        for (int num : nums) {
            list.add(num);
        }
    }

    private static int degree(HashSet<Integer>[] network, int cur, int y, HashSet<Integer> vis, int ans) {
        if (vis.contains(cur)) {
            return Integer.MAX_VALUE;
        }
        if (network[cur].isEmpty()) {
            return Integer.MAX_VALUE;
        }
        if (cur == y) {
            return ans;
        }

        vis.add(cur);
        for (int friend : network[cur]) {
            answer = Math.min(degree(network, friend, y, vis, ans + 1), answer);
        }
        vis.remove(cur);

        return Integer.MAX_VALUE;
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