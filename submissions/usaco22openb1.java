import java.io.*;
import java.util.StringTokenizer;

//Template generated on 4/19/2022

public class Photoshoot {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        readInt();
        char[] cows = readLine().toCharArray();
        int wrong = 0;

        int ans = 1;
        StringBuilder pairs = new StringBuilder();
        for (int i = 0; i < cows.length; i += 2) {
            if (cows[i] == cows[i + 1]) {
                continue;
            }
            String pair = String.valueOf(cows[i]) + cows[i + 1];
            pairs.append(pair.equals("GH") ? 1 : 0);
        }
        int cutoff = pairs.length() - 1;
        for (int i = cutoff; i >= 0; i--) {
            if (pairs.charAt(i) == '0') {
                cutoff--;
            } else {
                break;
            }
        }
        String string = pairs.substring(0, cutoff + 1);
        char prev = 0;
        for (char c : string.toCharArray()) {
            if (prev != 0) {
                if (prev != c) {
                    ans++;
                }
            }
            prev = c;
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