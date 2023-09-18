import java.io.*;
import java.util.*;

//Template generated on 2021-11-17

public class AliceShoppingTrip {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int maxTime = readInt(), numberOfStores = readInt();
        int[] stores = new int[numberOfStores];
        for (int i = 0; i < numberOfStores; i++) {
            stores[i] = readInt();
        }
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int store : stores) {
            temp.put(store, Math.abs(store));
        }
        Comparator<Integer> comparator = (o1, o2) -> {
            if (temp.get(o1).equals(temp.get(o2))) {
                return o1.compareTo(o2);
            } else {
                return temp.get(o1).compareTo(temp.get(o2));
            }
        };
        TreeMap<Integer, Integer> distances = new TreeMap<>(comparator);
        distances.putAll(temp);

        int time = 0;
        int pos = 0;
        int satisfied = 0;
        HashSet<Integer> visited = new HashSet<>();
        for (int store : distances.keySet()) {
            if (visited.contains(store)) {
                continue;
            }
            visited.add(store);
            int distance = Math.abs(pos - store);
            if (distance + time > maxTime) {
                break;
            } else {
                time += distance;
                pos = store;
                satisfied++;
            }
            if (time > maxTime) {
                break;
            }
        }
        pr.println(satisfied);
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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}