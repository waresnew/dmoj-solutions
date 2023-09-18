import java.io.*;
import java.util.StringTokenizer;

// 4/26/2022

@SuppressWarnings("DuplicatedCode")
public class COWOperations {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        String s = readLine();
        int[] cPsa = new int[s.length()];
        int[] oPsa = new int[s.length()];
        int[] wPsa = new int[s.length()];
        for (int i = 0; i < cPsa.length; i++) {
            if (s.charAt(i) == 'C') cPsa[i]++;
            if (i != 0) {
                cPsa[i] += cPsa[i - 1];
            }
        }
        for (int i = 0; i < oPsa.length; i++) {
            if (s.charAt(i) == 'O') oPsa[i]++;
            if (i != 0) {
                oPsa[i] += oPsa[i - 1];
            }
        }
        for (int i = 0; i < wPsa.length; i++) {
            if (s.charAt(i) == 'W') wPsa[i]++;
            if (i != 0) {
                wPsa[i] += wPsa[i - 1];
            }
        }
        int numberOfQueries = readInt();
        for (int q = 0; q < numberOfQueries; q++) {
            int left = readInt() - 1, right = readInt() - 1;
            int c = cPsa[right] - (left == 0 ? 0 : cPsa[left - 1]);
            int o = oPsa[right] - (left == 0 ? 0 : oPsa[left - 1]);
            int w = wPsa[right] - (left == 0 ? 0 : wPsa[left - 1]);
            c += w;
            o += w;
            if (c % 2 != 0 && o % 2 == 0) {
                pr.print("Y");
            } else {
                pr.print("N");
            }
        }
        pr.println();
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