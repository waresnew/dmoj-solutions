import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Stargazing {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    static class Planet {

        final int x;
        final int y;

        Planet(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Planet) {
                Planet p = (Planet) o;
                return x == p.x && y == p.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return x * 1000 + y;
        }

    }

    public static void main(String[] args) throws IOException {
        int numberOfPlanets = readInt();
        Planet[] planets = new Planet[numberOfPlanets];
        planets[0] = new Planet(0, 0);
        for (int i = 1; i < numberOfPlanets; i++) {
            int planet = readInt();
            int xOffset = readInt();
            int yOffset = readInt();
            planets[i] = new Planet(planets[planet - 1].x + xOffset, planets[planet - 1].y + yOffset);
        }
        HashSet<Planet> planetSet = new HashSet<>(Arrays.asList(planets));
        printer.println(planetSet.size());
        printer.close();
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