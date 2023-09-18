import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//Template generated on 2021-11-26

public class GoingBackToTheDefinitions {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfIntegers = readInt();
        Integer[] numbers = new Integer[numberOfIntegers];
        for (int i = 0; i < numberOfIntegers; i++) {
            numbers[i] = readInt();
        }
        Comparator<Integer> comparator = (o1, o2) -> {
            return (String.valueOf(o1) + o2).compareTo(String.valueOf(o2) + o1);
        };
        Arrays.sort(numbers, comparator);
        StringBuilder number = new StringBuilder();
        for (int i = numbers.length - 1; i >= 0; i--) {
            number.append(numbers[i]);
        }
        pr.println(number);
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