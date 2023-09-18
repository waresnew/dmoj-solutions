import java.io.*;
import java.util.StringTokenizer;

// 9/19/2022

@SuppressWarnings("DuplicatedCode")
public class ArrangingBooks {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        String input = readLine();
        int large = 0, small = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i)=='L') {
                large++;
            } else if (input.charAt(i)=='S') {
                small++;
            }
        }
        int ans = 0;
        int largeInSmall = 0, smallInLarge = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (i < large && c != 'L') {
                ans++;
                if (c == 'S') {
                    smallInLarge++;
                }
            }
            if (i > input.length()-small-1 && c != 'S') {
                ans++;
                if (c=='L') {
                    largeInSmall++;
                }
            }
        }
        ans -= Math.min(largeInSmall, smallInLarge);
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