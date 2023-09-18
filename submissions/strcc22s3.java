import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 11/19/2022

@SuppressWarnings({"DuplicatedCode", "unchecked", "RedundantSuppression"})
public class BorrowingChromebooks {
    private static final BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfChromebooks = readInt(), numberOfStudents = readInt(), queries = readInt();
        int[] students = new int[numberOfStudents + 1];
        ArrayList<Integer> history = new ArrayList<>();
        for (int i = 0; i < queries; i++) {
            String type = next();
            if (type.equals("b")) {
                int s = readInt();
                if (numberOfChromebooks==0) {
                    continue;
                }
                students[s]++;
                numberOfChromebooks--;
                history.add(s);
            } else if (type.equals("r")) {
                int s = readInt();
                students[s]--;
                numberOfChromebooks++;
            } else if (type.equals("p")) {
                int s = readInt();
                pr.println(students[s]);
            } else if (type.equals("c")) {
                pr.println(numberOfChromebooks);
            } else if (type.equals("l")) {
                int x = readInt();
                pr.println(history.get(history.size()-x));
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
        return bufferedReader.readLine();
    }
}