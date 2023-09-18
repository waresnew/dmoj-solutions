import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2021-11-16

public class Boxes {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Box implements Comparable<Box> {
        private final int[] dimensions = new int[3];

        private Box(int dim1, int dim2, int dim3) {
            dimensions[0] = dim1;
            dimensions[1] = dim2;
            dimensions[2] = dim3;
            Arrays.sort(dimensions);
        }

        @Override
        public int compareTo(Box o) {
            int volume1 = dimensions[0] * dimensions[1] * dimensions[2];
            int volume2 = o.dimensions[0] * o.dimensions[1] * o.dimensions[2];
            return Integer.compare(volume1, volume2);
        }

        @Override
        public String toString() {
            return dimensions[0] + " " + dimensions[1] + " " + dimensions[2];
        }
    }

    public static void main(String[] args) throws IOException {
        /*
        order of dimensions do not matter because rotation
         */
        int numberOfSizes = readInt();
        Box[] availableSizes = new Box[numberOfSizes];
        for (int i = 0; i < numberOfSizes; i++) {
            availableSizes[i] = new Box(readInt(), readInt(), readInt());
        }
        int numberOfBoxes = readInt();
        Box[] boxes = new Box[numberOfBoxes];
        for (int i = 0; i < numberOfBoxes; i++) {
            boxes[i] = new Box(readInt(), readInt(), readInt());
        }
        Arrays.sort(availableSizes);
        label1:
        for (Box box : boxes) {
            for (Box size : availableSizes) {
                int fits = fits(box, size);
                if (fits != -1) {
                    pr.println(fits);
                    continue label1;
                }
            }
            pr.println("Item does not fit.");
        }
        pr.close();
    }

    private static int fits(Box box, Box size) {
        boolean[] used = new boolean[3];
        boolean[] satisfied = new boolean[3];
        for (int i = 0; i < 3; i++) { //foreach dimension in box
            for (int j = 0; j < 3; j++) { //foreach dimension in size
                if (box.dimensions[i] <= size.dimensions[j] && !used[j]) {
                    used[j] = true;
                    satisfied[i] = true;
                    break;
                }
            }
        }
        if (Arrays.equals(new boolean[]{true, true, true}, satisfied)) {
            return size.dimensions[0] * size.dimensions[1] * size.dimensions[2];
        } else {
            return -1;
        }
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