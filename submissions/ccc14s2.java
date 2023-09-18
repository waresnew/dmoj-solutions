import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

//Template generated on 2021-10-27

public class AssigningPartners {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfStudents = readInt();
        HashMap<String, HashSet<Integer>> partners = new HashMap<>();
        for (int i = 0; i < numberOfStudents; i++) {
            String name = next();
            if (!partners.containsKey(name)) {
                partners.put(name, new HashSet<>());
            }
            partners.get(name).add(i);
        }
        for (int i = 0; i < numberOfStudents; i++) {
            String name = next();
            if (!partners.containsKey(name)) {
                partners.put(name, new HashSet<>());
            }
            partners.get(name).add(i);
        }
        HashMap<String, HashSet<Integer>> temp = new HashMap<>(partners);
        HashSet<String> removed = new HashSet<>();
        for (Map.Entry<String, HashSet<Integer>> entry : partners.entrySet()) {
            if (removed.contains(entry.getKey())) {
                continue;
            }
            temp.remove(entry.getKey());
            removed.add(entry.getKey());
            if (!temp.containsValue(entry.getValue())) {
                pr.println("bad");
                pr.close();
                return;
            }
            if (entry.getValue().size() == 1) {
                pr.println("bad");
                pr.close();
                return;
            }
            String keyToRemove = keyFromValue(entry.getValue(), temp);
            temp.remove(keyToRemove);
            removed.add(keyToRemove);
        }
        pr.println("good");
        pr.close();
    }

    private static String keyFromValue(HashSet<Integer> value, HashMap<String, HashSet<Integer>> map) {
        for (String key : map.keySet()) {
            if (map.get(key).equals(value)) {
                return key;
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