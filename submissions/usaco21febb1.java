import java.io.*;
import java.util.*;

//Template generated on 2021-11-01

public class YearOfTheCow {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private enum Relation {
        PREVIOUS,
        NEXT
    }

    private static class Hint {
        private final String subject;
        private final String target;
        private final Relation relation;
        private final String zodiac;

        private Hint(String subject, String target, Relation relation, String zodiac) {
            this.subject = subject;
            this.target = target;
            this.relation = relation;
            this.zodiac = zodiac;
        }

        @Override
        public String toString() {
            return subject + " " + target;
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfHints = readInt();
        Hint[] hints = new Hint[numberOfHints];
        List<String> zodiacs = Arrays.asList("Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat");
        HashMap<String, Integer> birthdays = new HashMap<>();
        birthdays.put("Bessie", 0);
        for (int i = 0; i < numberOfHints; i++) {
            String line = readLine();
            String[] input = line.split(" ");
            hints[i] = new Hint(input[0], input[7], Relation.valueOf(input[3].toUpperCase(Locale.ROOT)), input[4]);
        }
        ArrayList<Hint> order = new ArrayList<>();
        String next = null;
        boolean foundElsie = false;
        //determine optimal order
        label:
        for (Hint h : hints) {
            for (Hint hint : hints) {
                if (!foundElsie && hint.subject.equals("Elsie")) {
                    foundElsie = true;
                    order.add(hint);
                    next = hint.target;
                    if (hint.target.equals("Bessie")) {
                        break label;
                    }
                    break;
                } else if (hint.subject.equals(next)) {
                    order.add(hint);
                    next = hint.target;
                    if (hint.target.equals("Bessie")) {
                        break label;
                    }
                    break;
                }
            }
        }
        Collections.reverse(order);
        //get differences
        for (Hint hint : order) {
            int difference;
            int targetZodiac = 0;
            for (Hint hint1 : hints) {
                if (hint1.subject.equals(hint.target)) {
                    targetZodiac = zodiacs.indexOf(hint1.zodiac);
                    break;
                }
            }
            int zodiac = zodiacs.indexOf(hint.zodiac);
            if (hint.relation == Relation.NEXT) {
                if (targetZodiac < zodiac) {
                    difference = targetZodiac - zodiac;
                } else {
                    difference = 12 - Math.abs(zodiac - targetZodiac);
                }
                birthdays.put(hint.subject, birthdays.get(hint.target) + Math.abs(difference));

            } else {
                if (zodiac < targetZodiac) {
                    difference = Math.abs(zodiac - targetZodiac);
                } else {
                    difference = 12 - Math.abs(zodiac - targetZodiac);
                }
                birthdays.put(hint.subject, birthdays.get(hint.target) - difference);
            }
        }

        pr.println(Math.abs(birthdays.get("Elsie")));
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