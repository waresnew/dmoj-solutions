import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class ThatMissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean readingCount = true;
        int count = 0;
        int i = 0;
        TreeMap<Integer, ArrayList<Integer>> numbers = new TreeMap<>();
        int time = 0;
       while (time < 5) {
           String string = bufferedReader.readLine();
            if (readingCount) {
                count = Integer.parseInt(string);
                readingCount = false;
            } else {
                if (i < count) {
                    i++;
                    if (!numbers.containsKey(time)) {
                        numbers.put(time, new ArrayList<>());
                    }
                        numbers.get(time).add(Integer.parseInt(string));

                }
                if (i >= count) {
                    Collections.sort(numbers.get(time));
                    readingCount = true;
                    time++;
                    count = 0;
                    i = 0;
                }
            }
        }
        for (ArrayList<Integer> array : numbers.values()) {
            int previous = 0;
            for (int j = 0; j < array.size(); j++) {
                int integer = array.get(j);
                if (integer - previous != 1) {
                    System.out.println(previous + 1);
                    break;
                } else {
                    previous = integer;
                }
                if (j == array.size() - 1) {
                    System.out.println(array.size() + 1);
                    break;
                }
            }

        }
    }
}