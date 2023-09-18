import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 4/3/2022

public class BobInWonderland {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfStudents = readInt(), numberOfRollerCoasters = readInt();
        int[] students = new int[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            students[i] = readInt();
        }
        int[] coasters = new int[numberOfRollerCoasters];
        for (int i = 0; i < numberOfRollerCoasters; i++) {
            coasters[i] = readInt();
        }
        Arrays.sort(students);
        for (int coaster : coasters) {
            int eligible = numberOfStudents - binarySearch(students, coaster);
            if (eligible == numberOfStudents + 1) {
                eligible = 0;
            }
            pr.println(eligible);
        }
        pr.close();
    }

    private static int binarySearch(int[] array, int key) {
        int low = 0, high = array.length - 1, answer = -1;
        while (low <= high) {
            boolean reset = false;
            int middle = (low + high) / 2;
            if (array[middle] == key) {
                if (middle != 0 && array[middle - 1] != array[middle]) {
                    return middle;
                } else {
                    answer = middle;
                    high = middle - 1;
                    low = 0;
                    reset = true;
                }
            }
            if (array[middle] > key) {
                high = middle - 1;
                answer = middle;
            } else if (!reset) {
                low = middle + 1;
            }
        }
        return answer;
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