import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SilentAuction {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String highestBidder = null;
        int highestAmount = -1;
        String line;
        int numberOfBidders = -1;
        String currentBidder = null;
        int biddersSoFar = 0;
        while ((line = bufferedReader.readLine()) != null) {

            if (numberOfBidders == -1) {
                numberOfBidders = Integer.parseInt(line);
            } else if (currentBidder == null) {
                currentBidder = line;

            } else {
                int money = Integer.parseInt(line);
                if (money > highestAmount) {
                    highestAmount = money;
                    highestBidder = currentBidder;
                }
                currentBidder = null;
                biddersSoFar += 1;
            }
            if (biddersSoFar == numberOfBidders) {
                break;
            }
        }
        System.out.println(highestBidder);

    }
}