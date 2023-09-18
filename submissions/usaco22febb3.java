import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Blocks {
    private static StringTokenizer stringTokenizer;
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static HashSet<ArrayList<Integer>> perms = new HashSet<>();

    public static void main(String[] args) throws IOException {
        int numberOfWords = Integer.parseInt(next());
        String[] blocks = new String[4];
        for (int i = 0; i < 4; i++) {
            blocks[i] = bufferedReader.readLine();
        }
        String[] words = new String[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {
            words[i] = bufferedReader.readLine();
        }
        ArrayList<Integer> start = new ArrayList<>();
        generatePerms(4, start, new HashSet<>(start));

        label:
        for (String word : words) {
            for (ArrayList<Integer> perm : perms) {
                boolean works = true;
                for (int i = 0; i < word.length(); i++) {
                    if (!blocks[perm.get(i)].contains(String.valueOf(word.charAt(i)))) {
                        works = false;
                        break;
                    }
                }

                if (works) {
                    pr.println("YES");
                    continue label;
                }
            }
            pr.println("NO");

        }
        pr.close();
    }

    private static void generatePerms(int number, ArrayList<Integer> current, HashSet<Integer> used) {
        if (current.size() == number) {
            perms.add(current);
            return;
        }
        for (int i = 0; i < number; i++) {
            if (!used.contains(i)) {
                ArrayList<Integer> copy = new ArrayList<>(current);
                copy.add(i);
                HashSet<Integer> copy2 = new HashSet<>(used);
                copy2.add(i);
                generatePerms(number, copy, copy2);
            }
        }
    }


    private static String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine().trim());
        }
        return stringTokenizer.nextToken();
    }
}