import java.io.*;
import java.util.StringTokenizer;

// 5/2/2022

@SuppressWarnings("DuplicatedCode")
public class Nizovi {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static int indent = 0;

    public static void main(String[] args) throws IOException {
        String string = readLine();
        String[] elements = string.split(",");
        char[] array = string.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '{') {
                pr.println(indent() + "{");
                indent += 2;
                continue;
            }
            if (array[i] == '}') {
                indent -= 2;
                pr.print(indent() + "}");
                if (i != array.length - 1 && array[i + 1] != ',') {
                    pr.println();
                }
                continue;
            }
            if (array[i] == ',') {
                pr.println(",");
                continue;
            }
            if (array[i - 1] == '{' || array[i - 1] == ',') {
                pr.print(indent());
            }
            pr.print(array[i]);
            if (i != array.length - 1 && array[i + 1] == '}') {
                pr.println();
            }
        }
        pr.println();
        pr.close();
    }

    private static String indent() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            output.append(" ");
        }
        return output.toString();
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