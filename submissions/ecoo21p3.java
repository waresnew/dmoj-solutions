import java.io.*;
import java.util.*;

// 5/9/2022

@SuppressWarnings("DuplicatedCode")
public class QuintessentialQuestions {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Response implements Comparable<Response> {
        private final int professor, score;

        private Response(int professor, int score) {
            this.professor = professor;
            this.score = score;
        }

        @Override
        public int compareTo(Response o) {
            return Integer.compare(score, o.score);
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfQuestions = readInt(), numberOfProfessors = readInt(), numberOfEmails = readInt();
        HashMap<Integer, TreeSet<Response>> emails = new HashMap<>();
        for (int i = 0; i < numberOfEmails; i++) {
            int prof = readInt(), question = readInt(), score = readInt();
            emails.putIfAbsent(question, new TreeSet<>(Comparator.reverseOrder()));
            emails.get(question).add(new Response(prof, score));
        }
        for (int i = 1; i <= numberOfQuestions; i++) {
            if (emails.get(i) == null) {
                pr.print(-1);
            } else {
                pr.print(emails.get(i).first().professor);
            }
            if (i != numberOfQuestions) {
                pr.print(" ");
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
        return bufferedReader.readLine();
    }
}