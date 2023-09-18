import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

//Template generated on 2022-02-24

public class HockeyBracket {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfCountries = readInt(), groupSize = readInt();
        @SuppressWarnings("unchecked")
        HashMap<Integer, Integer>[] groups = new HashMap[numberOfCountries / groupSize];
        HashMap<Integer, Integer> groupAssoc = new HashMap<>();
        for (int i = 0; i < groups.length; i++) {
            groups[i] = new HashMap<>();
        }
        for (int i = 0; i < groups.length; i++) {
            for (int j = 0; j < groupSize; j++) {
                int country = readInt();
                groupAssoc.put(country, i);
                groups[i].put(country, 0);
            }
        }
        for (int i = 0; i < ((groupSize - 1) * numberOfCountries) / 2; i++) {
            int country1 = readInt(), country2 = readInt();
            String result = next();
            int group1 = groupAssoc.get(country1), group2 = groupAssoc.get(country2);
            if (result.equals("W")) {
                groups[group1].put(country1, groups[group1].get(country1) + 3);
            } else if (result.equals("L")) {
                groups[group2].put(country2, groups[group2].get(country2) + 3);
            } else {
                groups[group1].put(country1, groups[group1].get(country1) + 1);
                groups[group2].put(country2, groups[group2].get(country2) + 1);
            }
        }
        int targetPlace = readInt();
        for (int i = 0; i < groups.length; i++) {
            HashMap<Integer, Integer> members = groups[i];
            Comparator<Integer> comparator = (o1, o2) -> {
                int points1 = members.get(o1);
                int points2 = members.get(o2);
                if (points1 == points2) {
                    return Integer.compare(o1, o2);
                } else {
                    return -Integer.compare(points1, points2);
                }
            };
            TreeMap<Integer, Integer> sorted = new TreeMap<>(comparator);
            sorted.putAll(members);
            int counter = 0;
            for (int country : sorted.keySet()) {
                counter++;
                if (counter == targetPlace) {
                    pr.print(country + (i == groups.length - 1 ? "" : " "));
                    break;
                }
            }
        }
        pr.println();
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