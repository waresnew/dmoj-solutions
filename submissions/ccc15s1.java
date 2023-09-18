import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

// 10/31/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class ZeroThatOut {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = readInt(); i >0 ; i--) {
            int n = readInt();
            if (n==0) {
                nums.remove(nums.size()-1);
            } else {
                nums.add(n);
            }
        }
        AtomicInteger ans = new AtomicInteger();
        nums.forEach(ans::addAndGet);
        pr.println(ans.intValue());
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