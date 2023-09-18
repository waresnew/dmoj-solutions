import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

//Template generated on 4/3/2022

public class PairsOfMultiples {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException { //do something similar to sieve (+= factor each time)
        int size = readInt();
        int[] array = new int[size];
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < size; i++) {
            array[i] = readInt();
            max = Math.max(max, array[i]);
            freq.putIfAbsent(array[i], 0);
            freq.put(array[i], freq.get(array[i])+1);
        }
        long answer = 0;
        for (int i = 0; i < size; i++) {
            for (int j = array[i]; j <= max; j+=array[i]) {
                if (j == array[i]) {
                    answer += freq.get(j)-1;
                }
                  if (j != array[i] && freq.containsKey(j)) {
                      answer+=freq.get(j);
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