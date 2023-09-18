import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoilingWater {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int temp = Integer.parseInt(bufferedReader.readLine());
        int pressure = 5*temp-400;
        System.out.println(pressure);
        System.out.println(pressure > 100 ? "-1" : pressure < 100 ? "1" : "0");
    }
}