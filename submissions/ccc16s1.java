import java.io.*;
import java.util.StringTokenizer;

// 10/24/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class Ragaman {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int[] freq = new int[26], freqB = new int[26];
        int wildcards = 0;
        String a = readLine(), b = readLine();
        for (char c : a.toCharArray()) {
            freq[c-'a']++;
        }
        for (char c : b.toCharArray()) {
            if (c=='*') {
                wildcards++;
            } else {
                freqB[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i]<freqB[i]) {
                pr.println("N");
                pr.close();
                return;
            }
            if (freq[i]>freqB[i]) {
                int diff = freq[i]-freqB[i];
                if (diff <= wildcards) {
                    wildcards -= diff;
                } else {
                    pr.println("N");
                    pr.close();
                    return;
                }
            }
        }
        pr.println("A");
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