import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

//Template generated on 2021-12-16

public class LousyChristmasPresents {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Frequency {
        private int firstIndex = Integer.MAX_VALUE;
        private int lastIndex = Integer.MIN_VALUE;
    }

    private static class Relative {
        private final int firstColour;
        private final int lastColour;

        private Relative(int firstIndex, int lastIndex) {
            this.firstColour = firstIndex;
            this.lastColour = lastIndex;
        }
    }

    public static void main(String[] args) throws IOException {
        int scarfLength = readInt(), numberOfRelatives = readInt();
        HashMap<Integer, Frequency> colours = new HashMap<>();
        for (int i = 0; i < scarfLength; i++) {
            int colour = readInt();
            colours.putIfAbsent(colour, new Frequency());
            int firstIndex = colours.get(colour).firstIndex;
            int lastIndex = colours.get(colour).lastIndex;
            colours.get(colour).firstIndex = Math.min(firstIndex, i);
            colours.get(colour).lastIndex = Math.max(lastIndex, i);
        }
        Relative[] relatives = new Relative[numberOfRelatives];
        for (int i = 0; i < numberOfRelatives; i++) {
            relatives[i] = new Relative(readInt(), readInt());
        }
        int answer = 0;
        for (Relative relative : relatives) {
            if (colours.get(relative.firstColour) == null || colours.get(relative.lastColour) == null) {
                continue;
            }
            answer = Math.max(answer, colours.get(relative.lastColour).lastIndex - colours.get(relative.firstColour).firstIndex + 1);
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