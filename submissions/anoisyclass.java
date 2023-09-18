import java.io.*;
import java.util.*;

// 5/31/2022

@SuppressWarnings("DuplicatedCode")
public class ANoisyClass {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Snapshot {
        private int cur;
        private HashSet<Integer> vis;

        public Snapshot(int cur, HashSet<Integer> vis) {
            this.cur = cur;
            this.vis = vis;
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfStudents = readInt(), numberOfConnections = readInt();
        HashMap<Integer, ArrayList<Integer>> connections = new HashMap<>(); //key = noisy, value = distarcted
        for (int i = 0; i < numberOfConnections; i++) {
            int a = readInt(), b = readInt();
            connections.putIfAbsent(a, new ArrayList<>());
            connections.get(a).add(b);
        }
        ArrayDeque<Snapshot> stack = new ArrayDeque<>();
        for (int key : connections.keySet()) {
            HashSet<Integer> temp = new HashSet<>();
            temp.add(key);
            stack.push(new Snapshot(key, temp));
        }
        while (!stack.isEmpty()) {
            Snapshot snapshot = stack.pop();
            if (connections.get(snapshot.cur) != null) {
                for (int next : connections.get(snapshot.cur)) {
                    if (snapshot.vis.contains(next)) {
                        pr.println("N");
                        pr.close();
                        return;
                    }
                    HashSet<Integer> newVis = new HashSet<>(snapshot.vis);
                    newVis.add(next);
                    stack.push(new Snapshot(next, newVis));
                }
            }
        }
        pr.println("Y");
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