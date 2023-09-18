import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 5/9/2022

@SuppressWarnings("DuplicatedCode")
public class Distance {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfHouses = readInt();
        ArrayDeque<Integer> houses = new ArrayDeque<>();
        for (int i = 1; i <= numberOfHouses; i++) {
            houses.add(i);
        }
        StringBuilder output = new StringBuilder();
        output.append(houses.pop()).append(" ");
        boolean rightDirection = true;
        while (!houses.isEmpty()) {
            int left = houses.peek(), right = houses.getLast();
            if (left == right) {
                output.append(left).append(" ");
                break;
            }
            if (rightDirection) {
                output.append(right).append(" ");
                houses.removeLast();
            } else {
                output.append(left).append(" ");
                houses.pop();
            }
            rightDirection = !rightDirection;
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
        return bufferedReader.readLine();
    }
}