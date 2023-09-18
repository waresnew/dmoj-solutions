import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecretInstructions {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String previous = "";
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("99999")) {
                break;
            }
            String[] chars = line.split("");
            int number1 = Integer.parseInt(chars[0]);
            int number2 = Integer.parseInt(chars[1]);

            String rest = line.substring(2);
            if (number1 + number2 == 0) {
                System.out.println(previous + rest);
            } else if ((number1 + number2) % 2 == 0) {
                System.out.println("right " + rest);
                previous = "right ";
            } else if ((number1 + number2) % 2 != 0) {
                System.out.println("left " + rest);
                previous = "left ";
            }

            }
        }

}