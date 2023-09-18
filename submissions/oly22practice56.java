import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 6/12/2022

@SuppressWarnings("DuplicatedCode")
public class ArtAuction {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Artwork implements Comparable<Artwork>{
        private int alice, bob;

        @Override
        public int compareTo(Artwork o) {
            return Integer.compare(bob-alice, o.bob-o.alice);
        }
    }

    public static void main(String[] args) throws IOException {
        int total = readInt(), limit = readInt();
        Artwork[] art = new Artwork[total];
        for (int i = 0; i < total; i++) {
            art[i] = new Artwork();
            art[i].alice = readInt();
        }
        for (int i = 0; i <total; i++) {
            art[i].bob = readInt();
        }
        Arrays.sort(art, Comparator.reverseOrder());
        int ans = 0;
        for (int i = 0; i < limit; i++) {
            ans += art[i].bob;
        }
        for (int i = limit; i < total;i++) {
            ans += art[i].alice;
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