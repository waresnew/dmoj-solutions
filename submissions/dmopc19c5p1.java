import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CrypticChecklist {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int totalItems = readInt();
        String[] items = new String[totalItems];
        int totalAssignments = readInt();
        int counter = 0;
        ArrayList<HashSet<String>> assignments = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {
            items[i] = next();
        }
        for (int i = 0; i < totalAssignments; i++) {
            int totalItemsNeeded = readInt();
            HashSet<String> itemsNeeded = new HashSet<>();
            for (int j = 0; j < totalItemsNeeded; j++) {
                itemsNeeded.add(next());
            }
            assignments.add(itemsNeeded);
        }
        for (HashSet<String> assignment : assignments) {
            int satisfied = 0;
            for (String requiredItem : assignment) {
                for (String item : items) {
                    if (requiredItem.equals(item)) {
                        satisfied++;
                        break;
                    }
                }
                if (satisfied == assignment.size()) {
                    counter++;
                }
            }
        }
        printer.println(counter);
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