import java.io.*;
import java.util.*;

//Template generated on 2022-02-15

public class WaitTime {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Message {
        private final char type;
        private final int number;

        private Message(char type, int number) {
            this.type = type;
            this.number = number;
        }

        @Override
        public String toString() {
            return type + " " + number;
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfMessages = readInt();
        Message[] messages = new Message[numberOfMessages];
        HashMap<Integer, Integer> totalWaitTimes = new HashMap<>();
        HashMap<Integer, Integer> currentWaitTimes = new HashMap<>();
        for (int i = 0; i < numberOfMessages; i++) {
            String line = readLine();
            int friend = Integer.parseInt(line.substring(2));
            if (line.charAt(0) != 'W') {
                totalWaitTimes.putIfAbsent(friend, 0);
                currentWaitTimes.putIfAbsent(friend, 0);
            }
            messages[i] = new Message(line.charAt(0), friend);
        }
        HashSet<Integer> waiting = new HashSet<>();
        Message previous = null;
        for (Message message : messages) {
            if (message.type != 'W' && previous != null) {
                if (previous.type != 'W') {
                    for (int person : waiting) {
                        currentWaitTimes.put(person, currentWaitTimes.get(person) + 1);
                    }
                } else {
                    for (int person : waiting) {
                        currentWaitTimes.put(person, currentWaitTimes.get(person) + previous.number);
                    }
                }
            }
            if (message.type == 'S') {
                totalWaitTimes.put(message.number, totalWaitTimes.get(message.number) + currentWaitTimes.get(message.number));
                currentWaitTimes.put(message.number, 0);
                waiting.remove(message.number);
            }
            if (message.type == 'R') {
                waiting.add(message.number);
            }
            previous = message;
        }
        for (int stillWaiting : waiting) {
            totalWaitTimes.put(stillWaiting, -1);
        }
        TreeMap<Integer, Integer> sorted = new TreeMap<>(totalWaitTimes);
        for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
            pr.println(entry.getKey() + " " + (entry.getValue()));
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