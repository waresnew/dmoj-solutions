import java.io.*;
import java.util.*;

//Template generated on 2021-10-27

public class CrayolaLightsaber {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static final List<Colour> stick = new ArrayList<>();
    private static final ArrayList<Colour> colours = new ArrayList<>();

    private static class Colour {
        private boolean used = false;
        private final String colour;

        private Colour(String colour) {
            this.colour = colour;
        }

        private Colour use() {
            used = true;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Colour) {
                return colour.equals(((Colour) o).colour);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return colour.hashCode();
        }

        @Override
        public String toString() {
            return colour;
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfColours = readInt();

        for (int i = 0; i < numberOfColours; i++) {
            colours.add(new Colour(next()));
        }
        colours.sort(Comparator.comparing(i -> Collections.frequency(colours, i)).reversed());
        stick.add(colours.get(0).use());
        while (findValidColour() != null) {
            Colour colour = findValidColour();
            stick.add(colour);
            colour.used = true;

        }
        pr.println(stick.size());
        pr.close();
    }

    private static Colour findValidColour() {
        for (Colour colour : colours) {
            if (colour.used) {
                continue;
            }
            if (!stick.get(stick.size() - 1).equals(colour)) {
                return colour;
            }
        }
        return null;
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