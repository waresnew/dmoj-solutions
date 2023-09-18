import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

//Template generated on 3/22/2022

public class ObligatoryGeometryProblem {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfPolygons = readInt(), numberOfQueries = readInt();
        HashMap<Integer, String> shapes = new HashMap<>();
        for (int i = 1; i <= numberOfPolygons; i++) {
            shapes.put(i, "rhombus");
        }
        for (int i = 0; i < numberOfQueries; i++) {
            String type = next(), shape = next();
            int num = readInt();
            if (type.equals("get")) {
                pr.println(shapes.get(num).equals(shape) ? 1 : 0);
            } else {
                shapes.put(num, shape);
            }
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