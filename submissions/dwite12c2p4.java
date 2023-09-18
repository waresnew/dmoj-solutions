import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MagicTrick {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int time = 0;
        while (time < 5) {
            int totalCards = Integer.parseInt(bufferedReader.readLine());
            String[] stringCards = bufferedReader.readLine().split(" ");
            List<Integer> cards = new ArrayList<>();
            List<Integer> answer = new ArrayList<>();
            for (int i = totalCards; i>=1; i--) {
                cards.add(i);
            }
            for (int i = 0; i < totalCards; i++) {
                int card = Integer.parseInt(stringCards[i]);
                if (cards.size() <= card) {
                    break;
                }
                answer.add(cards.get(card));
                cards.remove(card);
            }
            if (answer.size() == totalCards) {
                for (int i : answer) {
                    System.out.print(i + " ");
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
            time++;
        }
    }
}