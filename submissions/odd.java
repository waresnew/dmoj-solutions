import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5/17/2022

@SuppressWarnings("DuplicatedCode")
public class TheOddNumber {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int numbers = Integer.parseInt(bufferedReader.readLine());
        int ans = 0;
        for (int i = 0; i < numbers; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            ans ^= n;
        }
        System.out.println(ans);
    }
}