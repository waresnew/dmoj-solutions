import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

//Template generated on 2022-01-28

public class FujoNeko {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfRows = readInt(), numberOfColumns = readInt();
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();
        for (int i = 0; i < numberOfRows; i++) {
            String line = readLine();
            boolean hasRow = false;
            for (int j = 0; j < numberOfColumns; j++) {
                char input = line.charAt(j);
                if (input == 'X') {
                    columns.add(j);
                    hasRow = true;
                }
            }
            if (hasRow) {
                rows.add(i);
            }
        }
        int numberOfBeings = readInt();
        for (int i = 0; i < numberOfBeings; i++) {
            int column = readInt() - 1, row = readInt() - 1;
            if (rows.contains(row) || columns.contains(column)) {
                pr.println("Y");
                continue;
            }
            pr.println("N");
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