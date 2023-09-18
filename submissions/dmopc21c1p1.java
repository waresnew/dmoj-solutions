import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PartialGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        long duke = 0;
        long alice = 0;
        for (String string : bufferedReader.readLine().split(" ")) {
            long number = Long.parseLong(string);
            if (number % 2 == 0) {
                duke += Math.ceil(number / 2f);
            } else {
                alice += Math.ceil(number / 2f);
            }
        }
        System.out.println(duke > alice ? "Duke" : "Alice");
    }
}