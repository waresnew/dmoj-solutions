import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Gates {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int total = readInt();
        TreeSet<Integer> gates = new TreeSet<>();
        for (int i = 1; i <= total ; i++) {
            gates.add(i);
        }
        /*
        dock at the highest possible number
         */
        int satisfied = 0;

        int numberOfPlanes = readInt();
        for (int i = 0; i < numberOfPlanes; i++) {
            int desiredDock = readInt();
            if (gates.contains(desiredDock-1)) {
                gates.remove(desiredDock-1);
                satisfied++;
            } else {
                boolean canDock = false;
                Integer index = gates.floor(desiredDock);
                if (index != null) {
                    gates.remove(index);
                    canDock = true;
                    satisfied++;
                }
                
                if (!canDock) {
                    break;
                }
            }
        }
        printer.println(satisfied);
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