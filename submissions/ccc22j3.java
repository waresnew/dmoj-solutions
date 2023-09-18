import java.io.*;

public class HarpTuning {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        String instructions = bufferedReader.readLine();
        String[] array = instructions.split("");
        StringBuilder answer = new StringBuilder();
        boolean reachedPlus = false;
        StringBuilder tightFactor = new StringBuilder();
        for (String character : array) {
            if (!reachedPlus) {
                if (character.equals("+")) {
                    answer.append(" tighten ");
                    reachedPlus = true;
                } else if (character.equals("-")) {
                    answer.append(" loosen ");
                    reachedPlus = true;
                } else {
                    answer.append(character);
                }
            } else {
                try {
                    Integer.parseInt(character);
                    tightFactor.append(character);
                } catch (NumberFormatException ignored) {
                    answer.append(tightFactor);
                    pr.println(answer.toString().trim());
                    answer = new StringBuilder();
                    tightFactor = new StringBuilder();
                    reachedPlus = false;
                    answer.append(character);
                }
            }
        }
        answer.append(tightFactor);
        pr.println(answer.toString().trim());
        pr.close();
    }
}