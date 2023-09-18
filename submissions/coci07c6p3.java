import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

//Template generated on 3/1/2022

public class Granica {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfNumbers = readInt(), numbers[] = new int[numberOfNumbers];
        for (int i = 0; i < numberOfNumbers; i++) {
            numbers[i] = readInt();
        }
        int[] differences = new int[numberOfNumbers - 1];
        for (int i = 0; i < numberOfNumbers - 1; i++) {
            differences[i] = Math.abs(numbers[i] - numbers[i + 1]);
        }
        HashSet<Integer> commonFactors = new HashSet<>();
        int gcf = gcf(differences);
        commonFactors.add(gcf);
        for (int i = 2; i <= Math.sqrt(gcf); i++) {
            if (gcf % i == 0) {
                commonFactors.add(i);
                commonFactors.add(gcf / i);
            }
        }
        StringBuilder output = new StringBuilder();
        for (int commonFactor : commonFactors) {
            output.append(commonFactor).append(" ");
        }

        pr.println(output.toString().trim());
        pr.close();
    }

    private static int gcf(int number1, int number2) {
        if (number1 == 0) {
            return number2;
        }
        return gcf(number2 % number1, number1);
    }

    private static int gcf(int[] numbers) {
        int answer = numbers[0];
        for (int number : numbers) {
            answer = gcf(number, answer);
        }
        return answer;
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