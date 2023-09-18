import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SleepingInClass {
    private static StringTokenizer stringTokenizer;
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int numberOfCases = Integer.parseInt(next());
        for (int test = 0; test < numberOfCases; test++) {
            int numberOfClasses = Integer.parseInt(next());
            int[] classes = new int[numberOfClasses];
            int[] classesPsa = new int[numberOfClasses];
            HashSet<Integer> psaSet = new HashSet<>();
            for (int i = 0; i < numberOfClasses; i++) {
                classes[i] = Integer.parseInt(next());
                classesPsa[i] = (i == 0 ? 0 : classesPsa[i - 1]) + classes[i];
                psaSet.add(classesPsa[i]);
            }
            if (classesPsa[classesPsa.length - 1] == 0) {
                pr.println(classesPsa[classesPsa.length - 1]);
                continue;
            }
            int answer = numberOfClasses;
            for (int i = numberOfClasses; i > 0; i--) {
                if (classesPsa[classesPsa.length - 1] % i == 0) {
                    boolean valid = true;
                    for (int j = classesPsa[classesPsa.length - 1] / i; j <= classesPsa[classesPsa.length - 1]; j += classesPsa[classesPsa.length - 1] / i) {
                        if (!psaSet.contains(j)) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        answer = numberOfClasses - i;
                        break;
                    }
                }
            }
            pr.println(answer);
        }
        pr.close();
    }

    private static String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine().trim());
        }
        return stringTokenizer.nextToken();
    }
}