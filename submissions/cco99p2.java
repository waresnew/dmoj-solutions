import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//Template generated on 2021-11-02

public class CommonWords {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfQueries = readInt();
        for (int i = 0; i < numberOfQueries; i++) {
            int numberOfWords = readInt();
            int rank = readInt();
            HashMap<String, Integer> frequencies = new HashMap<>();
            for (int j = 0; j < numberOfWords; j++) {
                String word = readLine();
                frequencies.putIfAbsent(word, 0);
                frequencies.put(word, frequencies.get(word) + 1);
            }

            ArrayList<String> desiredWords = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
                int counter = 0;
                for (Map.Entry<String, Integer> entry1 : frequencies.entrySet()) {
                    if (entry1.getValue() > entry.getValue()) {
                        counter++;
                    }
                }
                if (counter == rank - 1) {
                    desiredWords.add(entry.getKey());
                }
            }
            String prefix;
            String stringRank = String.valueOf(rank);
            if (stringRank.length() > 1 && stringRank.substring(stringRank.length() - 2).matches("11|12|13")) {
                prefix = "th";
            } else {
                int digit = rank % 10;
                prefix = "th";
                if (digit == 1) {
                    prefix = "st";
                } else if (digit == 2) {
                    prefix = "nd";
                } else if (digit == 3) {
                    prefix = "rd";
                }
            }

            pr.println(rank + prefix + " most common word(s):");
            for (String word : desiredWords) {
                pr.println(word);
            }
            if (i != numberOfQueries - 1) {
                pr.println();
            }


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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}