import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//Template generated on 3/29/2022

public class Bananas {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class BSChunk implements Comparable<BSChunk> {
        private int start;
        private int end;

        private BSChunk(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(BSChunk o) {
            return Integer.compare(start, o.start);
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            String word = readLine();
            if (word.equals("X")) {
                break;
            }
            if (word.startsWith("N") || word.endsWith("N")) {
                pr.println("NO");
                continue;
            }
            pr.println(isMonkey(word, false) ? "YES" : "NO");
        }
        pr.close();
    }

    private static boolean isMonkey(String word, boolean stripped) {
        if (isA(word)) {
            return true;
        }
        if (!stripped) {
            ArrayList<BSChunk> bsChunks = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            ArrayList<Integer> s = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                if (character == 'B') {
                    b.add(i);
                } else if (character == 'S') {
                    s.add(i);
                    if (s.size() == b.size()) {
                        bsChunks.add(new BSChunk(b.get(0), s.get(s.size() - 1)));
                        b.clear();
                        s.clear();
                    }
                }
            }
            Collections.sort(bsChunks);
            StringBuilder builder = new StringBuilder(word);
            for (BSChunk bsChunk : bsChunks) {
                if (!isA(builder.substring(bsChunk.start, bsChunk.end + 1))) {
                    return false;
                }
                for (int i = bsChunk.start; i <= bsChunk.end+1; i++) {
                    if (i < builder.length()) {
                        if (builder.charAt(i) == 'N' && i == builder.length()-1) {
                            continue;
                        }
                        builder.setCharAt(i, '0');
                    }
                }
            }
            boolean allZero = true;
            for (char character : builder.toString().toCharArray()) {
                if (character != '0') {
                    allZero = false;
                    break;
                }
            }
            if (allZero && builder.length() != 0) {
                return true;
            }
            return isMonkey(builder.toString().replace("0", ""), true);
        } else {
            String[] potentialA = word.split("N");
            if (potentialA.length == 0) {
                return false;
            }
            for (String string : potentialA) {
                if (!isA(string)) {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean isA(String word) {
        if (word.equals("A")) {
            return true;
        }
        if (word.startsWith("B") && word.endsWith("S")) {
            return isMonkey(word.substring(1, word.length() - 1), false);
        }
        return false;
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