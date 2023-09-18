import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

//Template generated on 2022-02-24

public class AddUpApples {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int number = readInt();
        HashSet<String> sums = new HashSet<>();
        for (int i = 1; i <= number / 2; i++) {
            getSums(number, sums, i, i, number + "=" + i);
        }
        sums.forEach(pr::println);
        pr.println("total=" + sums.size());

        pr.close();
    }

    private static void getSums(int num, HashSet<String> output, int previous, int sum, String answer) {
        if (sum == num) {
            output.add(answer);
            return;
        }
        for (int i = previous; sum + i <= num; i++) {
            getSums(num, output, i, sum + i, answer + "+" + i);
        }
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