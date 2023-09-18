import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Template generated on 3/22/2022

public class ObligatoryPermutationProblem {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfElements = readInt();
        long numberOfOperations = readLong();
        int[] original = new int[numberOfElements];
        int[] numbers = new int[numberOfElements];
        boolean[] visited = new boolean[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            original[i] = readInt();
        }
        for (int i = 0; i < numberOfElements; i++) {
            if (visited[i]) {
                continue;
            }
            ArrayList<Integer> cycle = new ArrayList<>();
            for (int j = i; !visited[j]; j = original[j]-1) {
                cycle.add(j);
                visited[j] = true;
            }
            int remainder = (int) (numberOfOperations % cycle.size());
            for (int j = 0; j < cycle.size(); j++) {
                numbers[cycle.get((j + remainder) % cycle.size())] = original[cycle.get(j)];
            }
        }
        for (int i = 0; i < numberOfElements; i++) {
            pr.print(numbers[i] + (i == numberOfElements - 1 ? "\n" : " "));
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
        return bufferedReader.readLine().trim();
    }
}