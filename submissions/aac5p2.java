import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2022-02-02

public class PermutationsAndProducts {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int totalNumbers = readInt();
        long minimum = Long.MAX_VALUE, maximum = 0;
        long first = -1;
        long[] products = new long[totalNumbers+1];
        for (int i = 2; i <= totalNumbers; i++) {
            System.out.println("? 1" + " " + i);
            System.out.flush();
            products[i] = readLong();
            minimum = Math.min(minimum, products[i]);
            maximum = Math.max(maximum, products[i]);
        }
        if (minimum == 2) {
            if (maximum == totalNumbers) {
                first = 1;
            } else {
                first = 2;
            }
        } else {
            first = minimum;
        }
        System.out.print("! " +  first);
        for (int i = 2; i <=  totalNumbers; i++) {
            System.out.print(" " + products[i]/first);
        }
        System.out.println();


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