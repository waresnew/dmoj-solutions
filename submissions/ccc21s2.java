import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

//Template generated on 2022-01-21

public class ModernArt {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int count = 0;
        HashMap<String, Integer> counter = new HashMap<>();
        int height = readInt();
        int width = readInt();
        int numberOfChoices = readInt();
        for (int i = 0; i < numberOfChoices; i++) {
            String readLine = readLine();
            if (!counter.containsKey(readLine)) {
                counter.put(readLine, 1);
            } else {
                counter.put(readLine, counter.get(readLine) + 1);
            }
        }

        // long startTime = System.currentTimeMillis();
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                String key = "R " + j;
                int total = 0;
                Integer value = counter.get(key);
                if (value != null) {
                    total += value;
                }
                key = "C " + i;
                value = counter.get(key);
                if (value != null) {
                    total += value;
                }
                if (total % 2 == 1) {
                    count++;
                }
            }
        }
        // long endTime = System.currentTimeMillis();
        pr.println(count);
        pr.close();
        //  System.out.println(endTime - startTime);
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