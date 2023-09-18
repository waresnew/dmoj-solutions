import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NonTransitiveDice {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Result {
        private int firstTotal;
        private int secondTotal;

        private Result(int firstTotal, int secondTotal) {
            this.firstTotal = firstTotal;
            this.secondTotal = secondTotal;
        }
    }

    public static void main(String[] args) throws IOException {
        /*
        to check if die a is better than die b:
        see how many other numbers can a single roll beat
        eg. dice a vs dice b
            4 beats 2 (1) (1 total)
            5 beats 2,4 (2) (3 total)
            6 beats 2,4,5
            etc.
            check if a total is higher than b total
         */
        int numberOfCases = Integer.parseInt(next());
        label:
        for (int testCase = 0; testCase < numberOfCases; testCase++) {
            int[] die1 = new int[4];
            int[] die2 = new int[4];
            for (int i = 0; i < 4; i++) {
                die1[i] = Integer.parseInt(next());
            }
            for (int i = 0; i < 4; i++) {
                die2[i] = Integer.parseInt(next());
            }
            Arrays.sort(die1);
            Arrays.sort(die2);
            Result result = compareDies(die1, die2);
            //c has to be better than a but worse than b
            if (result.firstTotal == result.secondTotal) {
                pr.println("no");
                continue;
            }
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    for (int k = 1; k <= 10; k++) {
                        for (int l = 1; l <= 10; l++) {
                            int[] die3 = new int[]{i, j, k, l};
                            if (result.firstTotal > result.secondTotal) {
                                Result ca = compareDies(die3, die1);
                                Result cb = compareDies(die3, die2);
                                if (ca.firstTotal > ca.secondTotal && cb.firstTotal < cb.secondTotal) {
                                    pr.println("yes");
                                    continue label;
                                }
                            } else {
                                Result ca = compareDies(die3, die2);
                                Result cb = compareDies(die3, die1);
                                if (ca.firstTotal > ca.secondTotal && cb.firstTotal < cb.secondTotal) {
                                    pr.println("yes");
                                    continue label;
                                }
                            }
                        }
                    }
                }
            }
            pr.println("no");

        }
        pr.close();


    }

    private static Result compareDies(int[] die1, int[] die2) {
        Arrays.sort(die1);
        Arrays.sort(die2);
        Result result = new Result(0, 0);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (die1[i] > die2[j]) {
                    result.firstTotal++;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (die2[i] > die1[j]) {
                    result.secondTotal++;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private static String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine().trim());
        }
        return stringTokenizer.nextToken();
    }
}