import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrashPush {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(bufferedReader.readLine());
        String[] outputStrings = new String[numberOfCases];
        for (int i = 0; i < numberOfCases; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            double output = Math.ceil(Double.parseDouble(line[0]) / Double.parseDouble(line[1]));
            if (output == 0) {
                outputStrings[i] = "0";
            } else {
                outputStrings[i] = String.valueOf(Math.round(output));
            }
        }
        for (String string : outputStrings) {
            System.out.println(string);
        }
}
}