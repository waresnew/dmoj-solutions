import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

//Template generated on 3/14/2022

public class ConstrainedPermutations {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        int number = readInt(), numberOfConstraints = readInt();
        HashMap<Integer, HashSet<Integer>> constraints = new HashMap<>();
        for (int i = 0; i < numberOfConstraints; i++) {
            int before = readInt(), after = readInt();
            constraints.putIfAbsent(after, new HashSet<>());
            constraints.get(after).add(before);
        }

        generatePerms(number, new ArrayList<>(), new HashSet<>(), constraints);
        pr.println(answer);
        pr.close();
    }

    private static void generatePerms(int number, ArrayList<Integer> current, HashSet<Integer> used, HashMap<Integer, HashSet<Integer>> constraints) {
        if (current.size() == number) {
            answer++;
            return;
        }
        label:
        for (int i = 1; i <= number; i++) {
            if (!used.contains(i-1)) {
                if (constraints.get(i) != null) {
                    HashSet<Integer> before = constraints.get(i);
                    for (int b : before) {
                        if (!used.contains(b-1)) {
                            continue label;
                        }
                    }
                }
                current.add(i);
                used.add(i-1);
                generatePerms(number, current, used, constraints);
                current.remove(current.size() - 1);
                used.remove(i-1);

            }
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