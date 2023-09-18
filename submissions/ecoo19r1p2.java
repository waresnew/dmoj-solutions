import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//Template generated on 4/18/2022

@SuppressWarnings("DuplicatedCode")
public class LSystemsGo {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        for (int t = 0; t < 10; t++) {
            int numberOfRules = readInt();
            int iterations = readInt();
            String[] string = next().split("");
            HashMap<String, String> rules = new HashMap<>();
            for (int i = 0; i < numberOfRules; i++) {
                rules.put(next(), next());
            }
            String first = string[0], last = string[string.length - 1];
            for (int i = 0; i < iterations; i++) {
                first = String.valueOf(rules.get(first).charAt(0));
                last = String.valueOf(rules.get(last).charAt(rules.get(last).length() - 1));
            }
            //length
            long length = 0;
            HashMap<String, Long> frequency = new HashMap<>();
            for (int i = 65; i <= 90; i++) {
                frequency.put(String.valueOf((char) i), 0L);
            }
            for (int i = 97; i <= 122; i++) {
                frequency.put(String.valueOf((char) i), 0L);
            }
            for (String character : string) {
                frequency.put(character, frequency.get(character) + 1);
            }
            for (int i = 0; i < iterations; i++) {
                HashMap<String, Long> additions = new HashMap<>();
                for (long j = 65; j <= 90; j++) {
                    additions.put(String.valueOf((char) j), 0L);
                }
                for (long j = 97; j <= 122; j++) {
                    additions.put(String.valueOf((char) j), 0L);
                }
                for (Map.Entry<String, Long> entry : frequency.entrySet()) {
                    if (entry.getValue() == 0) {
                        continue;
                    }
                    for (char c : rules.get(entry.getKey()).toCharArray()) {
                        String s = String.valueOf(c);
                        additions.put(s, additions.get(s) + entry.getValue());
                    }
                    additions.put(entry.getKey(), additions.get(entry.getKey()) - entry.getValue());
                }
                for (Map.Entry<String, Long> entry : additions.entrySet()) {
                    frequency.put(entry.getKey(), frequency.get(entry.getKey()) + entry.getValue()); //merge maps
                }
            }
            for (long freq : frequency.values()) {
                length += freq;
            }
            pr.println(first + last + " " + length);
        }
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