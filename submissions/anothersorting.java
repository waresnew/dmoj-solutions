import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//Template generated on 2021-11-26

public class AnotherSorting {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfIntegers = readInt();
        Integer[] numbers = new Integer[numberOfIntegers];
        for (int i = 0; i < numberOfIntegers; i++) {
            numbers[i] = readInt();
        }
        Comparator<Integer> unitComparator = (o1, o2) -> {
            int unit1 = o1 % 10;
            int unit2 = o2 % 10;
            if (unit1 == unit2) {
                return o2.compareTo(o1);
            } else {
                return Integer.compare(unit1, unit2);
            }
        };
        Arrays.sort(numbers, unitComparator);
        for (int number : numbers) {
            pr.print(number + " ");
        }
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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}