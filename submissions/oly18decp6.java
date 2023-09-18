import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

//Template generated on 2021-11-07

public class GrowingTrees {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Tree {
        private int height;
        private final int speed;

        private Tree(int height, int speed) {
            this.height = height;
            this.speed = speed;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tree tree = (Tree) o;
            return height == tree.height;
        }

        public boolean instanceEquals(Object o) {
            return super.equals(o);
        }

        @Override
        public int hashCode() {
            return Objects.hash(height);
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfTrees = readInt();
        Set<Tree> trees = new HashSet<>();
        for (int i = 0; i < numberOfTrees; i++) {
            trees.add(new Tree(readInt(), readInt()));
        }
        if (numberOfTrees > trees.size()) {
            pr.println("0");
            pr.close();
            return;
        }
        boolean impossible = true;
        label:
        for (Tree tree : trees) {
            for (Tree tree1 : trees) {
                if (tree.instanceEquals(tree1)) {
                    continue;
                }
                if (tree.height < tree1.height && tree.speed > tree1.speed) {
                    impossible = false;
                    break label;
                }
            }
        }
        if (impossible) {
            pr.println("-1");
            pr.close();
            return;
        }
        int years = 0;
///impossible if ther is no tree with at least 1 tree with larger height but smaller speed
        int previousSize = trees.size();
        while (years < 10000) {
            years++;
            for (Tree tree : trees) {
                tree.height += tree.speed;
            }
            Set<Tree> newSet = new HashSet<>(trees);
            if (previousSize > newSet.size()) {
                pr.println(years);
                pr.close();
                return;
            }
            previousSize = newSet.size();
        }
       pr.println("-1");
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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}