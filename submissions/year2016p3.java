import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

// 6/6/2022

@SuppressWarnings("DuplicatedCode")
public class ArithmeticSnowman {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfSnowballs = readInt();
        int[] snowballs = new int[numberOfSnowballs];

        HashSet<Integer> snowballSet = new HashSet<>();
        for (int i = 0; i < numberOfSnowballs; i++) {
            snowballs[i] = readInt();
            snowballSet.add(snowballs[i]);
        }

        int ans = Integer.MIN_VALUE;
        if (numberOfSnowballs <= 100) {
            for (int i = 0; i < numberOfSnowballs; i++) {
                for (int j = 0; j < numberOfSnowballs; j++) {
                    if (i == j) {
                        continue;
                    }
                    for (int k = 0; k < numberOfSnowballs; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        int[] array = new int[]{
                                snowballs[i], snowballs[j], snowballs[k]
                        };
                        Arrays.sort(array);
                        if (array[1]-array[0]==array[2]-array[1]) {
                            ans = Math.max(ans, array[0]+array[1]+array[2]);
                        }

                    }
                }
            }
            pr.println(ans);
            pr.close();
            return;
        }
        for (int first = 0; first < numberOfSnowballs; first++) {
            for (int second = 0; second < numberOfSnowballs; second++) {
                if (first == second) {
                    continue;
                }
                int third = Math.max(snowballs[first], snowballs[second]) + Math.abs(snowballs[second] - snowballs[first]);
                if (snowballSet.contains(third)) {
                    ans = Math.max(ans, snowballs[first] + snowballs[second] + third);
                }
            }
        }
        pr.println(ans);
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