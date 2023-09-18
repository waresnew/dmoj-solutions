import java.io.*;
import java.util.StringTokenizer;

// 9/12/2022

@SuppressWarnings("DuplicatedCode")
public class IsItATree {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int[][] graph = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                graph[i][j] = readInt();
            }
        }
        double edges = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (graph[i][j] == 1) {
                    edges++;
                }
            }
        }
        edges /= 2;
        int vertices = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (graph[i][j] ==1) {
                    vertices++;
                    break;
                }
            }
        }
        if (edges == vertices-1) {
            pr.println("Yes");
        } else {
            pr.println("No");
        }
        pr.close();
    }
        private static String next () throws IOException {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens())
                stringTokenizer = new StringTokenizer(bufferedReader.readLine().trim());
            return stringTokenizer.nextToken();
        }

        @SuppressWarnings("unused")
        private static long readLong () throws IOException {
            return Long.parseLong(next());
        }

        @SuppressWarnings("unused")
        private static int readInt () throws IOException {
            return Integer.parseInt(next());
        }

        @SuppressWarnings("unused")
        private static double readDouble () throws IOException {
            return Double.parseDouble(next());
        }

    /*
    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }
    */

        @SuppressWarnings("unused")
        private static String readLine () throws IOException {
            return bufferedReader.readLine();
        }
    }