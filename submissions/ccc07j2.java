import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Text {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean ttyl = false;
        while (!ttyl) {
            String input = bufferedReader.readLine();
            switch (input) {
                case "CU":
                    System.out.println("see you");
                    break;
                case ":-)":
                    System.out.println("I'm happy");
                    break;
                case ":-(":
                    System.out.println("I'm unhappy");
                    break;
                case ";-)":
                    System.out.println("wink");
                    break;
                case ":-P":
                    System.out.println("stick out my tongue");
                    break;
                case "(~.~)":
                    System.out.println("sleepy");
                    break;
                case "TA":
                    System.out.println("totally awesome");
                    break;
                case "CCC":
                    System.out.println("Canadian Computing Competition");
                    break;
                case "CUZ":
                    System.out.println("because");
                    break;
                case "TY":
                    System.out.println("thank-you");
                    break;
                case "YW":
                    System.out.println("you're welcome");
                    break;
                case "TTYL":
                    System.out.println("talk to you later");
                    ttyl = true;
                    break;
                default:
                    System.out.println(input);
            }
        }
    }
}