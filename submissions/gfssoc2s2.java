import java.io.*;
import java.util.*;

//Template generated on 2021-11-16

public class Hearth {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Card implements Comparable<Card> {
        private final String name;
        private final int cost;

        private Card(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }

        @Override
        public int compareTo(Card o) {
            return name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private static class Combination {
        private final List<Card> cards;

        private Combination(Card card1, Card card2, Card card3) {
            cards = Arrays.asList(card1, card2, card3);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Combination that = (Combination) o;
            return cards.containsAll(that.cards);
        }

        @Override
        public int hashCode() {
            return cards.hashCode();
        }

        @Override
        public String toString() {
            cards.sort(Comparator.naturalOrder());
            return cards.get(0).toString() + " " + cards.get(1).toString() + " " + cards.get(2).toString();
        }

    }

    public static void main(String[] args) throws IOException {
        int numberOfCards = readInt(), mana = readInt();
        Card[] cards = new Card[numberOfCards];
        for (int i = 0; i < numberOfCards; i++) {
            String name = next();
            int cost = readInt();
            if (cost > mana - 2) {
                continue;
            }
            cards[i] = new Card(name, cost);
        }
        HashSet<Combination> combinations = new HashSet<>();
        for (Card card1 : cards) {
            if (card1 == null) {
                continue;
            }
            for (Card card2 : cards) {
                if (card2 == null) {
                    continue;
                }
                if (card2.equals(card1)) {
                    continue;
                }
                for (Card card3 : cards) {
                    if (card2.equals(card3) || card1.equals(card3)) {
                        continue;
                    }
                    if (card3 == null) {
                        continue;
                    }
                    if (card1.cost + card2.cost + card3.cost <= mana) {
                        combinations.add(new Combination(card1, card2, card3));
                    }
                }
            }
        }
        TreeSet<String> output = new TreeSet<>();
        for (Combination combination : combinations) {
            output.add(combination.toString());
        }
        for (String combo : output) {
            pr.println(combo);
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