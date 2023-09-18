import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2021-12-06

public class QueensCantAttackMe {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int length = readInt(), numberOfQueens = readInt();
        boolean[][] grid = new boolean[length][length];
        Integer[] queensRow = new Integer[numberOfQueens], queensColumn = new Integer[numberOfQueens];
        for (int i = 0; i < numberOfQueens; i++) {
            queensRow[i] = readInt() - 1;
            queensColumn[i] = readInt() - 1;
        }
        int answer = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (Arrays.asList(queensRow).contains(i) || Arrays.asList(queensColumn).contains(j)) {
                    grid[i][j] = true;
                }
                for (int k = 0; k < numberOfQueens; k++) {
                    if (Math.abs(queensRow[k] - i) == Math.abs(queensColumn[k] - j)) {
                        grid[i][j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (!grid[i][j]) {
                    answer++;
                }
            }
        }
        pr.println(answer);
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