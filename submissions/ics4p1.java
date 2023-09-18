import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

//Template generated on 3/1/2022

public class WordScrambler {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static final HashSet<String> permutations = new HashSet<>();


    public static void main(String[] args) throws IOException {
        String word = readLine();
        String[] array = word.split("");
        for (String string : array) {
            ArrayList<String> pool = new ArrayList<>();
            for (String string1 : array) {
                pool.add(string1);
            }
            pool.remove(string);
            getPerms(string, pool);

        }
        TreeSet<String> sorted = new TreeSet<>(permutations);
        sorted.forEach(pr::println);
        pr.close();
    }

    private static void getPerms(String number, ArrayList<String> pool) {
        if (pool.isEmpty()) {
            permutations.add(number);
            return;
        }
        for (String num : pool) {
            ArrayList<String> copy = new ArrayList<>(pool);
            copy.remove(num);
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