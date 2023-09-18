import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

//Template generated on 3/16/2022

public class Perket {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;
    private static int answer = Integer.MAX_VALUE;

    private static class Ingredient {
        private final int sourness, bitterness;

        private Ingredient(int sourness, int bitterness) {
            this.sourness = sourness;
            this.bitterness = bitterness;
        }

        @Override
        public String toString() {
            return sourness + " " + bitterness;
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfIngredients = readInt();
        Ingredient[] ingredients = new Ingredient[numberOfIngredients];
        for (int i = 0; i < numberOfIngredients; i++) {
            ingredients[i] = new Ingredient(readInt(), readInt());
        }
        generateCombos(new HashSet<>(), numberOfIngredients, ingredients, 1, 0);

        pr.println(answer);
        pr.close();
    }

    private static void generateCombos(HashSet<Ingredient> current, int targetSize, Ingredient[] pool, int sour, int bitter) {
        if (current.size() == targetSize) {
            return;
        }
        for (Ingredient ingredient : pool) {
            if (!current.contains(ingredient)) {
                current.add(ingredient);
                int newSour = sour * ingredient.sourness;
                int newBitter = bitter + ingredient.bitterness;
                answer = Math.min(answer, Math.abs(newSour - newBitter));
                generateCombos(current, targetSize, pool, newSour, newBitter);
                current.remove(ingredient);
            }
        }
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