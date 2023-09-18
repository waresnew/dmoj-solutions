import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 5/15/2022

@SuppressWarnings("DuplicatedCode")
public class NotEnoughTesters {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int[] factors = new int[100001];
        for (int i = 1; i <= factors.length; i++) {
            for (int j = i; j <= 100000; j += i) {
                if (j % i == 0) {
                    factors[j]++;
                }
            }
        }
        HashMap<Integer, ArrayList<Integer>> factorMap = new HashMap<>();
        for (int i = 1; i <= 100000; i++) {
            factorMap.putIfAbsent(factors[i], new ArrayList<>());
            factorMap.get(factors[i]).add(i);
        }
        for (int test = readInt(); test > 0; test--) {
            int target = readInt(), left = readInt(), right = readInt();
            if (factorMap.get(target) == null || factorMap.get(target).isEmpty()) {
                pr.println(0);
                continue;
            }
            int ans1 = binarySearch(factorMap.get(target), left, true);
            int ans2 = binarySearch(factorMap.get(target), right, false);
            if (ans1 == -1 || ans2 == -1) {
                pr.println(0);
                continue;
            }
            pr.println(ans2 - ans1 + 1);
        }
        pr.close();
    }

    private static int binarySearch(ArrayList<Integer> array, int key, boolean higher) {
        int low = 0, high = array.size() - 1, answer = -1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (array.get(middle) == key) {
                return middle;
            }
            if (array.get(middle) > key) {
                high = middle - 1;
                if (higher) {
                    answer = middle;
                }
            } else {
                low = middle + 1;
                if (!higher) {
                    answer = middle;
                }
            }
        }
        return answer;
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