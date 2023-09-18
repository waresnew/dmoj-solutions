import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

//Template generated on 3/23/2022

public class Gepetto {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        int numberOfIngredients = readInt(), numberOfRestrictions = readInt();
        HashMap<Integer, HashSet<Integer>> avoid = new HashMap<>();
        for (int i = 0; i < numberOfRestrictions; i++) {
            int a = readInt(), b = readInt();
            avoid.putIfAbsent(a, new HashSet<>());
            avoid.get(a).add(b);
            avoid.putIfAbsent(b, new HashSet<>());
            avoid.get(b).add(a);
        }
        combos(new ArrayList<>(), 1, numberOfIngredients, avoid);
        pr.println(answer);
        pr.close();
    }

    private static void combos(ArrayList<Integer> current, int number, int max, HashMap<Integer, HashSet<Integer>> avoid) {
        if (number > max) {
            answer++;
            return;
        }
        combos(current, number + 1, max, avoid);
        for (int ingredient : current) {
            if (avoid.get(ingredient) != null && avoid.get(ingredient).contains(number)) {
                return;
            }
        }
        current.add(number);
        combos(current, number + 1, max, avoid);
        current.remove(current.size() - 1);
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