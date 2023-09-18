import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Jerseys {
    static class Athlete {
        final int size;
        final int number;

        Athlete(char size, int number) {
            this.size = Jerseys.sizeToInt(size);
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfJerseys = Integer.parseInt(bufferedReader.readLine());
        int numberOfAthletes = Integer.parseInt(bufferedReader.readLine());
        int[] jerseys = new int[numberOfJerseys];
        int satisfied = 0;
        Athlete[] athletes = new Athlete[numberOfAthletes];
        for (int i = 0; i < numberOfJerseys; i++) {
            char size = bufferedReader.readLine().charAt(0);
            jerseys[i] = sizeToInt(size);
        }
        for (int i = 0; i < numberOfAthletes; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            athletes[i] = new Athlete(input[0].charAt(0), Integer.parseInt(input[1]));
        }
        for (Athlete athlete : athletes) {
            int number = athlete.number;
            int size = athlete.size;
            if (jerseys[number - 1] >= size) {
                jerseys[number - 1] = 0;
                satisfied++;
            }
        }
        System.out.println(satisfied);
    }

    static int sizeToInt(char size) {
        if (size == 'S') {
            return 1;
        } else if (size == 'M') {
            return 2;
        } else if (size == 'L') {
            return 3;
        } else {
            throw new IllegalArgumentException("Invalid size: " + size);
        }
    }
}