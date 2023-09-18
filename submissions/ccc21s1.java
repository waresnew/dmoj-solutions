import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2022-01-20

public class CrazyFencing {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Trapezoid {
        private int base1;
        private int base2;
        private int height;

        @Override
        public String toString() {
            return "Trapezoid{" +
                    "base1=" + base1 +
                    ", base2=" + base2 +
                    ", height=" + height +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfPieces = readInt();
        Trapezoid[] trapezoids = new Trapezoid[numberOfPieces];
        for (int i = 0; i < numberOfPieces; i++) {
            trapezoids[i] = new Trapezoid();
            trapezoids[i].base1 = readInt();
        }
        for (int i = 0; i < numberOfPieces; i++) {
            trapezoids[i].base2 = i == numberOfPieces - 1 ? readInt() : trapezoids[i + 1].base1;
        }
        for (int i = 0; i < numberOfPieces; i++) {
            trapezoids[i].height = readInt();
        }
        double area = 0;
        for (Trapezoid trapezoid : trapezoids) {
            area += ((trapezoid.base1 + trapezoid.base2) / 2.0) * trapezoid.height;
        }
        pr.println(area);
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
        return bufferedReader.readLine().trim();
    }
}