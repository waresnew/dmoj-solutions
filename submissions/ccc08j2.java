import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2021-12-16

public class DoTheShuffle {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        ArrayList<String> playlist = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));

        label:
        while (true) {
            int button = readInt(), numberOfPresses = readInt();
            switch (button) {
                case 1: {
                    for (int i = 0; i < numberOfPresses; i++) {
                        playlist.add(playlist.get(0));
                        playlist.remove(0);
                    }
                    break;
                }
                case 2: {
                    for (int i = 0; i < numberOfPresses; i++) {
                        String last = playlist.get(playlist.size() - 1);
                        playlist.add(0, last);
                        playlist.remove(playlist.size() - 1);
                    }
                    break;
                }
                case 3: {
                    String first = playlist.get(0);
                    String second = playlist.get(1);
                    playlist.set(0, second);
                    playlist.set(1, first);
                    break;
                }
                case 4: {
                    break label;
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (String title : playlist) {
            answer.append(title).append(" ");
        }
        pr.println(answer.toString().trim());
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