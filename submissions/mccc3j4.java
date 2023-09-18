import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

//Template generated on 2022-02-03

public class SnowballFight {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfStudents = readInt(), numberOfRounds = readInt();
        ArrayList<ArrayDeque<Integer>> students = new ArrayList<>();
        ArrayList<Integer> attackLog = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            attackLog.add(0);
        }
        for (int i = 0; i < numberOfStudents; i++) {
            students.add(new ArrayDeque<>());
            students.get(i).add(readInt());
        }
        for (int i = 0; i < numberOfRounds; i++) {
            HashSet<Integer> skip = new HashSet<>();
            for (int j = 0; j < numberOfStudents; j++) {
                if (skip.contains(j + 1)) {
                    continue;
                }
                Integer target = students.get(j).poll();
                if (target != null) {
                    attackLog.set(j, target);
                    if (students.get(target - 1).isEmpty()) {
                        skip.add(target);
                    }
                    students.get(target - 1).add(j + 1);

                }
            }
        }
        for (int i = 0; i < numberOfStudents; i++) {
            pr.print(attackLog.get(i));
            if (i != numberOfStudents - 1) {
                pr.print(" ");
            }
        }
        pr.println();
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