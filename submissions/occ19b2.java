import java.io.*;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

//Template generated on 2022-01-16

public class Cinematic {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfMovies = readInt(), numberOfWeeks = readInt();
        LinkedHashMap<String, Integer> movies = new LinkedHashMap<>();
        for (int i = 0; i < numberOfMovies; i++) {
            movies.put(readLine(), null);
        }
        for (String key : movies.keySet()) {
            movies.put(key, readInt());
        }
        long answer = 0;
        for (int i = 0; i < numberOfWeeks; i++) {
            String title = readLine();
            if (movies.get(title) != null) {
                answer += movies.get(title);
                movies.put(title, null);
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