import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//Template generated on 4/5/2022

public class GoodNumber {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        long number = readLong();
        int type = readInt();
        String string = String.valueOf(number);
        int firstDigit = Integer.parseInt(String.valueOf(string.charAt(0)));


        if (type == 0) {
            for (int i = firstDigit; i <= 9; i++) {
                StringBuilder current = new StringBuilder(String.valueOf(i));
                for (int k = 0; k < string.length() - 1; k++) {
                    current.append(i);
                }
                if (Long.parseLong(current.toString()) >= number) {
                    pr.println(current);
                    pr.close();
                    return;
                }
            }
        } else {
            ArrayList<Long> possible = new ArrayList<>();
            for (int i = 0; i < string.length(); i++) { //i is where the different digit will be
                for (int first = 0; first <= 9; first++) { //pick the diff digit
                    if (first == 0 && i == 0) {
                        continue;
                    }
                    for (int j = 0; j <= 9; j++) { //pick same digits
                        char[] current = new char[string.length()];
                        current[i] = String.valueOf(first).charAt(0); //set the diff digit
                        for (int k = 0; k < string.length(); k++) {
                            if (k == i) {
                                continue;
                            }
                            current[k] = String.valueOf(j).charAt(0);
                        }
                        if (new String(current).charAt(0) == '0') {
                            continue;
                        }
                        if (Long.parseLong(new String(current)) >= number) {
                            possible.add(Long.parseLong(new String(current)));
                        }
                    }
                }
            }
            Collections.sort(possible);
            pr.println(possible.get(0));

        }
        pr.close();
    }


    private static String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens())
            stringTokenizer = new StringTokenizer(bufferedReader.readLine().trim());
        return stringTokenizer.nextToken();
    }

    @SuppressWarnings("unused")
    private static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    @SuppressWarnings("unused")
    private static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    @SuppressWarnings("unused")
    private static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    /*
    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }
    */

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}