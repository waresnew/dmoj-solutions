import java.io.*;
import java.util.StringTokenizer;

//Template generated on 4/13/2022

public class KnittingScarves {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Node {
        private Node prev;
        private Node next;
        private final int index;

        public Node(Node prev, Node next, int index) {
            this.prev = prev;
            this.next = next;
            this.index = index;
        }

        @Override
        public String toString() {
            return prev.index + " " + next.index;
        }
    }


    public static void main(String[] args) throws IOException {
        int numberOfColours = readInt();
        Node[] scarf = new Node[numberOfColours + 2];
        Node previous = null;
        for (int i = 0; i <= numberOfColours + 1; i++) {
            scarf[i] = new Node(previous, null, i - 1);
            if (previous != null) {
                previous.next = scarf[i];
            }
            previous = scarf[i];
        }


        int head = 0;
        int numberOfQueries = readInt();
        for (int i = 0; i < numberOfQueries; i++) {
            int left = readInt(), right = readInt(), target = readInt();
            Node p1 = scarf[left];
            Node p2 = scarf[right];
            Node p0 = scarf[target];
            if (p0.next == p1) {
                continue;
            }
            p1.prev.next = p2.next;
            p2.next.prev = p1.prev;
            p2.next = p0.next;
            p0.next.prev = p2;
            p0.next = p1;
            p1.prev = p0;
        }
        StringBuilder output = new StringBuilder();
        Node node = scarf[head];
        while (true) {
            if (node.index == -1) {
                node = node.next;
                continue;
            }
            output.append(node.index + 1).append(" ");
            node = node.next;
            if (node.next == null) {
                break;
            }
        }
        pr.println(output.toString().trim());
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
        return bufferedReader.readLine().trim();
    }
}