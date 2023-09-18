import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Template generated on 2021-11-16

public class Maternity {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        String mother = readLine(), father = readLine();
        int numberOfBabies = readInt();
        String[] babies = new String[numberOfBabies];
        for (int i = 0; i < numberOfBabies; i++) {
            babies[i] = readLine();
        }
        boolean[] satisfiedBabies = new boolean[numberOfBabies];
        Arrays.fill(satisfiedBabies, true);
        for (int i = 0; i < numberOfBabies; i++) {
            for (int j = 0; j < 5; j++) {
                boolean dominant = Character.isUpperCase(babies[i].charAt(j));
                if (dominant) {
                    if (Character.isLowerCase(mother.charAt(j * 2)) && Character.isLowerCase(mother.charAt(j * 2 + 1)) && Character.isLowerCase(father.charAt(j * 2)) && Character.isLowerCase(father.charAt(j * 2 + 1))) {
                        satisfiedBabies[i] = false;
                        break;
                    }
                } else {
                    if ((Character.isUpperCase(mother.charAt(j * 2)) && Character.isUpperCase(mother.charAt(j * 2 + 1))) || (Character.isUpperCase(father.charAt(j * 2)) && Character.isUpperCase(j * 2 + 1))) {
                        satisfiedBabies[i] = false;
                        break;
                    }
                }
            }

        }
        for (boolean satisfied : satisfiedBabies) {
            if (satisfied) {
                pr.println("Possible baby.");
            } else {
                pr.println("Not their baby!");
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