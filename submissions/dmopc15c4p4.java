import java.io.*;
import java.util.*;

//Template generated on 2022-02-02

public class GreatSequence {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfIntegers = readInt(), minimum = readInt(), numberOfQueries = readInt();
        int[] numbers = new int[numberOfIntegers];
        int[] numberPsa = new int[numberOfIntegers];
        HashMap<Integer, ArrayList<Integer>> indexes = new HashMap<>();
        numberPsa[0] = readInt();
        numbers[0] = numberPsa[0];
        for (int i = 1; i < numberOfIntegers; i++) {
            int input = readInt();
            numbers[i] = input;
            numberPsa[i] = input + numberPsa[i - 1];
        }
        for (int i = 0; i < numberOfIntegers; i++) {
            indexes.putIfAbsent(numbers[i], new ArrayList<>());
            indexes.get(numbers[i]).add(i);
        }
        for (ArrayList<Integer> list : indexes.values()) {
            Collections.sort(list);
        }
        for (int i = 0; i < numberOfQueries; i++) {
            int number1 = readInt(), number2 = readInt(), left = readInt() - 1, right = readInt() - 1;
            boolean greatSequence = numberPsa[right] - (left == 0 ? 0 : numberPsa[left - 1]) > minimum;
            int binary1 = binarySearch(indexes.get(number1), left, right);
            int binary2 = binarySearch(indexes.get(number2), left, right);
            boolean hasNumbers = binary1 >= 0 && binary2 >= 0;
            if (greatSequence && hasNumbers) {
                pr.println("Yes");
            } else {
                pr.println("No");
            }
        }
        pr.close();
    }

    private static int binarySearch(List<Integer> array, int from, int to) {
        if (array == null) {
            return -1;
        }
        int low = 0;
        int high = array.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = array.get(mid);

            if (midVal < from)
                low = mid + 1;
            else if (midVal > to)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
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