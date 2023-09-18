import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

//Template generated on 3/13/2022

public class Photoshoot2 {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfCows = readInt();
        HashSet<Integer> used = new HashSet<>();
        int[] current = new int[numberOfCows], target = new int[numberOfCows];
        for (int i = 0; i < numberOfCows; i++) {
            current[i] = readInt();
        }
        for (int i = 0; i < numberOfCows; i++) {
            target[i] = readInt();
        }
        int answer = 0;
        for (int left = 0, right = 0; right < numberOfCows; right++) {
            while (left < numberOfCows && used.contains(current[left])) {
                left++;
            }
            if (current[left] == target[right]) {
                left++;
            } else {
                answer++;
                used.add(target[right]);
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