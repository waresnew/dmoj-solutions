import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 9/13/2022

@SuppressWarnings("DuplicatedCode")
public class VeraAndTrailBuilding {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int target = readInt();

        int bigVertices = (int) ((1 + Math.sqrt(8 * target + 1)) / 2);
        ArrayList<Integer> otherSizes = new ArrayList<>();
        int remaining = target - (bigVertices * (bigVertices - 1)) / 2;
        while (remaining > 2) {
            int next = (int) ((1 + Math.sqrt(8 * remaining + 1)) / 2), nextTriangle = (next * (next - 1)) / 2;
            remaining -= nextTriangle;
            otherSizes.add(next);
        }
        for (int i = 0; i < remaining; i++) {
            otherSizes.add(2);
        }

        StringBuilder output = new StringBuilder();

        for (int i = 1; i < bigVertices; i++) {
            output.append(i).append(" ").append(i + 1).append("\n");
        }
        output.append(bigVertices).append(" 1").append("\n");
        int currentVertex = bigVertices;
        for (int size : otherSizes) {
            output.append(currentVertex).append(" ").append(++currentVertex).append("\n");
            int original = currentVertex;
            for (; currentVertex < size + original - 1; currentVertex++) {
                output.append(currentVertex).append(" ").append(currentVertex + 1).append("\n");
            }
            output.append(currentVertex).append(" ").append(original).append("\n");
        }

        int totalVertices = 0, totalEdges = 0;
        for (char c : output.toString().toCharArray()) {
            if (c == '\n') {
                totalEdges++;
            }
            if (Character.isDigit(c)) {
                totalVertices = Math.max(totalVertices, Integer.parseInt(String.valueOf(c)));
            }
        }
        pr.println(currentVertex + " " + totalEdges);
        for (String s : output.toString().split("\n")) {
            pr.println(s);
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