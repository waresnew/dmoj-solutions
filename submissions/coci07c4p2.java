import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

//Template generated on 3/1/2022

public class Veci {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static final HashSet<Integer> permutations = new HashSet<>();

    public static void main(String[] args) throws IOException {
        String number = readLine();
        String[] array = number.split("");
        for (String string : array) {
            ArrayList<Integer> pool = new ArrayList<>();
            for (String string1 : array) {
                pool.add(Integer.parseInt(string1));
            }
            pool.remove(new Integer(Integer.parseInt(string)));
            getPerms(string, pool);

        }
        permutations.remove(Integer.parseInt(number));
        TreeSet<Integer> sorted = new TreeSet<>(permutations);
        Integer result = sorted.ceiling(Integer.parseInt(number));
        pr.println(result == null ? 0 : result);
        pr.close();
    }

    private static void getPerms(String number, ArrayList<Integer> pool) {
        if (pool.isEmpty()) {
            permutations.add(Integer.parseInt(number));
            return;
        }
        for (int num : pool) {
            ArrayList<Integer> copy = new ArrayList<>(pool);
            copy.remove(new Integer(num));
            getPerms(number + num, copy);
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