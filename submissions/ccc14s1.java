import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PartyInvitation {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfFriends = Integer.parseInt(bufferedReader.readLine());
        int[] friends = new int[numberOfFriends + 1];
        for (int i = 1; i < friends.length; i++) {
            friends[i] = i;
        }
        int numberOfRounds = Integer.parseInt(bufferedReader.readLine());
        int i = 0;
        while (i < numberOfRounds) {
            i++;
            int divisor = Integer.parseInt(bufferedReader.readLine());
            int counter = 0;
            for (int j = 1; j < friends.length; j++) {
                if (friends[j] != 0) {
                    counter++;
                    if (counter == divisor) {
                        friends[j] = 0;
                        counter = 0;
                    }
                }
            }
        }
        Arrays.sort(friends);
        for (int integer : friends) {
            if (integer != 0) {
                System.out.println(integer);
            }
        }

    }
}