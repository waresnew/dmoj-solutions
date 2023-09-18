import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PowerRankings {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    static class Student implements Comparable<Student> {
        final String name;
        int totalTime = 0;

        Student(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(o.totalTime, totalTime);
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfStudents = readInt();
        int numberOfPowerpoints = readInt();
        Student[] students = new Student[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            students[i] = new Student(next());
        }
        for (int i = 0; i < numberOfPowerpoints; i++) {
            for (int j = 0; j < numberOfStudents; j++) {
                students[j].totalTime += readInt();
            }
        }
        Arrays.sort(students);
        for (int i = 0; i < students.length; i++) {
            printer.println((i + 3) + ". " + students[i].name);
        }
        printer.close();
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