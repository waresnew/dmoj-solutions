import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Sorting {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int size = readInt();
        //check if zeroes are adjacent or if the numbers between them are the same
        int[] list = new int[size];
        List<Integer> wildcardIndexes = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int input = readInt();
            if (input == 0) {
                wildcardIndexes.add(i);
            }
            list[i] = input;
        }
        if (wildcardIndexes.isEmpty()) {
            for (int i = 0; i < list.length; i++) {
                if (i + 1 < list.length && list[i] > list[i + 1]) {
                    printer.println("NO");
                    printer.close();
                    return;
                }
            }
            printer.println("YES");
            printer.close();
            return;
        }


        boolean allAdjacent = true;
        Collections.sort(wildcardIndexes);
        List<Integer> indexesInBetween = new ArrayList<>();
        for (int i = wildcardIndexes.get(0); i <= wildcardIndexes.get(wildcardIndexes.size() - 1); i++) {
            if (list[i] != 0) {
                allAdjacent = false;
                indexesInBetween.add(i);
            }
        }
        int current = -1;
        if (!allAdjacent) {
            for (int index : indexesInBetween) {
                if (current == -1) {
                    current = list[index];
                } else if (list[index] != current) {
                    printer.println("NO");
                    printer.close();
                    return;
                }
            }
        }
        boolean sorted = true;
        boolean negative1 = false;
        boolean aboveSize = false;

        if (wildcardIndexes.get(0) - 1 < 0) {
            negative1 = true;
        }
        if ((wildcardIndexes.get(wildcardIndexes.size() - 1)) + 1 > list.length - 1) {
            aboveSize = true;
        }
        if (!negative1) {
            current = list[(wildcardIndexes.get(0)) - 1];

            for (int wildcard : wildcardIndexes) {
                list[wildcard] = current;
            }
            for (int i = 0; i < list.length; i++) {
                if (i + 1 < list.length && list[i] > list[i + 1]) {
                    sorted = false;
                    break;
                }
            }
        }
        if (!sorted && !aboveSize) {
            if ((wildcardIndexes.get(wildcardIndexes.size() - 1)) + 1 > list.length - 1) {
                printer.println("NO");
                printer.close();
                return;
            }
            current = list[(wildcardIndexes.get(wildcardIndexes.size() - 1)) + 1];
            for (int wildcard : wildcardIndexes) {
                list[wildcard] = current;
            }
            boolean sorted1 = true;
            for (int i = 0; i < list.length; i++) {
                if (i + 1 < list.length && list[i] > list[i + 1]) {
                    sorted1 = false;
                    break;
                }
            }
            sorted = sorted1;
        }
        if (sorted) {
            printer.println("YES");
        } else {
            printer.println("NO");
        }
        printer.close();

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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}