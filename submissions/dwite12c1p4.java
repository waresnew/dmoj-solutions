import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

// 5/3/2022

@SuppressWarnings("DuplicatedCode")
public class TrickOrTreeing {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static ArrayList<Node> leaves = new ArrayList<>();
    private static int targetCandy = 0;

    private static class Node {
        private Node left = null, right = null, parent = null;
        private int value = -1;
        private int height = 0;
    }

    private static class Range {
        private final int start, end;

        private Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        for (int test = 0; test < 5; test++) {
            Node root = new Node();
            String input = readLine();
            if (isNumber(input)) {
                pr.println("0 " + Integer.parseInt(input));
                continue;
            }
            buildTree(input, root);
            leaves.forEach(TrickOrTreeing::populateHeight);
            int candy = 0, roads = 0;
            ArrayDeque<Node> stack = new ArrayDeque<>();
            stack.push(root);
            HashSet<Node> vis = new HashSet<>();
            while (true) {
                Node cur = stack.peek();
                if (cur.value != -1) {
                    stack.pop();
                    candy += cur.value;
                    if (candy == targetCandy) {
                        break;
                    }
                    roads++;
                    continue;
                }
                Node child1 = cur.left, child2 = cur.right;
                boolean vis1 = vis.contains(child1), vis2 = vis.contains(child2);
                if (vis1 && !vis2) {
                    stack.push(child2);
                    vis.add(child2);
                } else if (!vis1 && vis2) {
                    stack.push(child1);
                    vis.add(child1);
                } else if (!vis1 && !vis2) {
                    if (child1.height < child2.height) {
                        stack.push(child1);
                        vis.add(child1);
                    } else {
                        stack.push(child2);
                        vis.add(child2);
                    }
                } else {
                    stack.pop();
                }
                roads++;
            }
            pr.println(roads + " " + candy);
            //cleanup
            leaves.clear();
            targetCandy = 0;
        }
        pr.close();
    }

    private static void populateHeight(Node child) {
        if (child.height != 0) { //already filled in
            return;
        }
        if (child.left == null && child.right == null) {
            populateHeight(child.parent);
            return;
        }
        child.height = Math.max(child.left.height, child.right.height) + 1;
        if (child.parent != null) { //is not root
            populateHeight(child.parent);
        }
    }

    private static void buildTree(String input, Node parent) {
        if (input.matches("\\(?[0-9]+ [0-9]+\\)?")) {
            String[] strip = input.replaceAll("[()]", "").split(" ");
            Node child1 = new Node(), child2 = new Node();
            child1.value = Integer.parseInt(strip[0]);
            child2.value = Integer.parseInt(strip[1]);
            targetCandy += child1.value;
            targetCandy += child2.value;
            child1.parent = parent;
            child2.parent = parent;
            parent.left = child1;
            parent.right = child2;
            leaves.add(child1);
            leaves.add(child2);
            return;
        }
        if (input.charAt(0) != '(') {
            StringBuilder num = new StringBuilder();
            int index = 0;
            for (int i = 0; i < input.length(); i++) {
                if (isNumber(String.valueOf(input.charAt(i)))) {
                    num.append(input.charAt(i));
                    index = i;
                } else {
                    break;
                }
            }
            Node node = new Node();
            node.value = Integer.parseInt(num.toString());
            leaves.add(node);
            targetCandy += node.value;
            parent.left = node;
            node.parent = parent;
            buildTree(input.substring(index + 1), parent);
            return;
        } else if (input.charAt(input.length() - 1) != ')') {
            StringBuilder num = new StringBuilder();
            int index = 0;
            for (int i = input.length() - 1; i >= 0; i--) {
                if (isNumber(String.valueOf(input.charAt(i)))) {
                    num.append(input.charAt(i));
                    index = i;
                } else {
                    break;
                }
            }
            Node node = new Node();
            node.value = Integer.parseInt(num.reverse().toString());
            leaves.add(node);
            targetCandy += node.value;
            parent.right = node;
            node.parent = parent;
            buildTree(input.substring(0, index), parent);
            return;
        }
        input = input.substring(1, input.length() - 1);
        String[] array = input.split("");
        int depth = 0;
        int splittingPoint = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("(")) {
                depth++;
            }
            if (array[i].equals(")")) {
                depth--;
            }
            if (depth == 0) {
                splittingPoint = i + 1;
                break;
            }
        }
        Node child1 = new Node(), child2 = new Node();
        child1.parent = parent;
        child2.parent = parent;
        parent.left = child1;
        parent.right = child2;
        String left = input.substring(0, splittingPoint);
        String right = input.substring(splittingPoint + 1);
        if (isNumber(left)) {
            Node node = new Node();
            node.value = Integer.parseInt(left);
            leaves.add(node);
            targetCandy += node.value;
            parent.left = node;
            node.parent = parent;
        } else {
            buildTree(left, child1);
        }
        if (isNumber(right)) {
            Node node = new Node();
            node.value = Integer.parseInt(right);
            leaves.add(node);
            targetCandy += node.value;
            parent.right = node;
            node.parent = parent;
        } else {
            buildTree(right, child2);
        }


    }

    private static boolean isNumber(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens())
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
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