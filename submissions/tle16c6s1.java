import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

//Template generated on 2021-10-27

public class WritingTheCCC {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;


    private static class Problem implements Comparable<Problem> {
        private final Type type;
        private final int index;

        private Problem(Type type, int index) {
            this.type = type;
            this.index = index;
        }

        @Override
        public int compareTo(Problem o) {
            if (!type.equals(o.type)) {
                return type.compareTo(o.type);
            } else {
                return Integer.compare(index, o.index);
            }
        }

    }

    private static class Type implements Comparable<Type> {
        private final String name;
        private final int priority;

        private Type(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Type) {
                return ((Type) o).name.equals(name);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return priority;
        }

        @Override
        public int compareTo(Type o) {
            return Integer.compare(priority, o.priority);
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfTypes = readInt();
        HashMap<String, Type> types = new HashMap<>();
        for (int i = 0; i < numberOfTypes; i++) {
            String next = next();
            types.put(next, new Type(next, i));
        }
        int numberOfProblems = readInt();
        Problem[] problems = new Problem[numberOfProblems];
        for (int i = 0; i < numberOfProblems; i++) {
            problems[i] = new Problem(types.get(next()), i);
        }
        Arrays.sort(problems);
        for (Problem problem : problems) {
            pr.println(problem.index + 1);
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