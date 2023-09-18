import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

//Template generated on 3/8/2022

public class PalindromicIntegerPartition {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static final HashMap<Integer, Long> cache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int number = readInt();
        pr.println(findSums(number));
        pr.close();
    }

    private static long findSums(int number) {
        if (number <= 1) return 1;
        if (cache.containsKey(number)) return cache.get(number);
        long answer = 1;
        for (int i = number - 2; i >= 0; i -= 2) {
            answer += findSums(i);
        }
        cache.put(number, answer);
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
        return bufferedReader.readLine().trim();
    }
}