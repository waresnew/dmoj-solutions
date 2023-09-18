import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uddered {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] alphabet = bufferedReader.readLine().toCharArray();
        char[] word = bufferedReader.readLine().toCharArray();
        int counter = 0;
        int wordI = 0;
        int i = 0;
        int attempt = 0;
        int attemptOfLast = 0;
        boolean firstTime = true;
        while (wordI < word.length) {
            i++;
            if (i == 26) {
                i = 0;
                attempt++;
            }
            if (alphabet[i] == word[wordI]) {
                if (attemptOfLast != attempt || firstTime) {
                    firstTime = false;
                    counter++;
                    attemptOfLast = attempt;
                }
                wordI++;
            }
        }
        System.out.println(counter);

    }
}