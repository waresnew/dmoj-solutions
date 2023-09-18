import java.io.*;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.StringTokenizer;

// 5/24/2022

@SuppressWarnings("DuplicatedCode")
public class BobsExpressionEvaluation {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        for (int test = 0; test < 5; test++) {
            String[] input = readLine().split(" ");
            ArrayDeque<String> stack = new ArrayDeque<>();

            if (!isNumber(input[input.length - 1])) {
                for (int i = 0; i < input.length;i++) {
                    if (isNumber(input[i])) {
                        stack.push(input[i]);
                    } else {
                        int b = Integer.parseInt(stack.pop()), a = Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(operate(a, b, input[i])));
                    }
                }
            } else {
                for (int i = input.length - 1; i >= 0; i--) {
                    if (isNumber(input[i])) {
                        stack.push(input[i]);
                    } else {
                        int a = Integer.parseInt(stack.pop()), b = Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(operate(a, b, input[i])));
                    }
                }
            }
            pr.println(stack.peek());
        }
        pr.close();
    }


    private static int operate(int a, int b, String op) {
        switch (op) {
            case "+": {
                return a + b;
            }
            case "-": {
                return a - b;
            }
            case "*": {
                return a * b;
            }
            case "/": {
                return a / b;
            }
            case "%": {
                return a % b;
            }
        }
        throw new IllegalArgumentException();
    }

    private static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
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
        return bufferedReader.readLine();
    }
}