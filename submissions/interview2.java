import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

//Template generated on 2021-11-28

public class CountTheTriplets {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfIntegers = readInt();
        int[] numbers = new int[numberOfIntegers];
        HashSet<Integer> sums = new HashSet<>();
        for (int i = 0; i < numberOfIntegers; i++) {
            numbers[i] = readInt();
            sums.add(numbers[i]);
        }
        Arrays.sort(numbers);
        int satisfied = 0;
        for (int i = 0; i < numberOfIntegers - 1; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numberOfIntegers; j++) {
                if (j > i+1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                if (sums.contains(numbers[i] + numbers[j])) {
                    satisfied++;
                }
            }
        }
        pr.println(satisfied == 0 ? -1 : satisfied);
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