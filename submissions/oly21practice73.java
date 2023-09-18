import java.io.*;
import java.util.*;

//Template generated on 2021-11-10

public class BobShufflingSequence {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfElements = readInt();

        int[] numbers = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            numbers[i] = readInt();
        }
        Arrays.sort(numbers);
        int left = 1;
        int right = numbers.length - 2;
        Deque<Integer> newArray = new ArrayDeque<>();
        newArray.addFirst(numbers[0]);
        newArray.addLast(numbers[numbers.length - 1]);
        while (left <= right) {
            int difference1 = Math.abs(newArray.peekFirst() - numbers[left]);
            int difference2 = Math.abs(newArray.peekLast() - numbers[left]);
            int difference3 = Math.abs(newArray.peekFirst() - numbers[right]);
            int difference4 = Math.abs(newArray.peekLast() - numbers[right]);
            List<Integer> list = Arrays.asList(difference1, difference2, difference3, difference4);
            int largest = Integer.MIN_VALUE;
            for (int number : list) {
                largest = Math.max(number, largest);
            }
            if (largest == difference1) {
                newArray.addFirst(numbers[left++]);
            } else if (largest == difference2) {
                newArray.addLast(numbers[left++]);
            } else if (largest == difference3) {
                newArray.addFirst(numbers[right--]);
            } else if (largest == difference4) {
                newArray.addLast(numbers[right--]);
            }
        }

        long sum = 0;
        Integer[] result = Arrays.copyOf(newArray.toArray(), newArray.size(), Integer[].class);
        for (int i = 0; i < result.length - 1; i++) {
            sum += Math.abs(result[i] - result[i + 1]);
        }
        pr.println(sum);
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