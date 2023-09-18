import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11/7/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class TheGenevaConfection {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        label:
        for (int test = readInt(); test > 0; test--) {
            int n = readInt();
            ArrayDeque<Integer> branch = new ArrayDeque<>();
            ArrayDeque<Integer> nums = new ArrayDeque<>();
            int[] sorted = new int[n];
            for (int i = 0; i < n; i++) {
                int a = readInt();
                sorted[i] = a;
                nums.push(a);
            }
            Arrays.sort(sorted);
            int target = 0;
            while (!nums.isEmpty()) {
                int cur = nums.peekFirst();
                if (cur != sorted[target]) {
                    if (!branch.isEmpty() && branch.peekFirst() == sorted[target]) {
                        branch.pop();
                        target++;
                    } else {
                        branch.push(nums.poll());
                    }
                } else {
                    nums.poll();
                    target++;
                }
            }
            while (!branch.isEmpty()) {
                if (branch.peekFirst() != sorted[target]) {
                    pr.println("N");
                    continue label;
                } else {
                    branch.pop();
                    target++;
                }
            }
            pr.println("Y");
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