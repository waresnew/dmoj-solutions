import java.io.*;
import java.util.StringTokenizer;

//Template generated on 3/22/2022

public class ObligatoryTriangleProblem {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Coordinate {
        private final double x, y;

        private Coordinate(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfPoints = readInt(), targetAngle = readInt();
        Coordinate[] points = new Coordinate[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++) {
            int x = readInt(), y = readInt();
            points[i] = new Coordinate(x, y);
        }
        int answer = 0;
        double bestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < numberOfPoints; i++) {
            double angle = Math.atan2(points[i].y, points[i].x) * (180 / Math.PI);
            if (angle < 0) {
                angle = 360 - Math.abs(angle);
            }
            double diff = Math.min(Math.abs(targetAngle - angle), 360 - Math.abs(angle - targetAngle));
            if (diff < bestDiff) {
                bestDiff = diff;
                answer = i + 1;
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