import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 5/18/2022

@SuppressWarnings("DuplicatedCode")
public class FoldingClothes {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfClothes = readInt();
        ArrayList<Integer> first = new ArrayList<>(), second = new ArrayList<>();
        for (int i = 0; i < numberOfClothes; i++) {
            first.add(readInt());
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < first.size(); i++) {
            if (first.get(i) >= prev) {
                prev = first.get(i);
            } else {
                ans.add(i);
                for (int j = 0; j < i; j++) {
                    second.add(first.get(j));
                }
                first.subList(0, i).clear();

                break;
            }
        }
        while (!first.isEmpty() && !second.isEmpty()) {
            if (first.get(0) >= second.get(second.size()-1)) {
                ans.add(-second.size());
                ans.add(second.size()+1);
                second.add(first.get(0));
                first.remove(0);
            } else {
                for (int i = 0; i < second.size(); i++) {
                    if (second.get(i) > first.get(0)) {
                        if (i != 0) {
                            ans.add(-i);
                        }
                        ans.add(i+1);
                        second.add(i, first.get(0));
                        first.remove(0);
                        break;
                    }
                }
            }
        }
        if (first.isEmpty()) {
            ans.add(-second.size());
        }
        pr.println(ans.size());
        ans.forEach(pr::println);
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