import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Template generated on 2021-11-02

public class MrNAndPresents {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfQueries = readInt();
        ArrayList<Integer> studentList = new ArrayList<>();
        for (int i = 0; i < numberOfQueries; i++) {
            char type = readCharacter();
            int student = readInt();
            switch (type) {
                case 'F': {
                    studentList.add(0, student);
                    break;
                }
                case 'E': {
                    studentList.add(studentList.size(), student);
                    break;
                }
                case 'R': {
                    studentList.remove(new Integer(student));
                    break;
                }
            }
        }
        for (Integer student : studentList) {
            pr.println(student);
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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}