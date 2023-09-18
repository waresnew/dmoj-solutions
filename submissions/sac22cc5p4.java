import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 5/31/2022

@SuppressWarnings("DuplicatedCode")
public class QueryingIntervals {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Interval implements Comparable<Interval> {
        private int start, end;

        private Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(start, o.start);
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfIntervals = readInt(), numberOfQueries = readInt();
        Interval[] intervals = new Interval[numberOfIntervals];
        for (int i = 0; i < numberOfIntervals; i++) {
            intervals[i] = new Interval(readInt(), readInt());
        }
        //merge
        Arrays.sort(intervals);
        for (int i = 0; i < numberOfIntervals - 1; i++) {
            Interval interval = intervals[i], next = intervals[i + 1];
            if (interval.end + 1 >= next.start) {
                next.end = Math.max(next.end, interval.end);
                next.start = interval.start;
                intervals[i] = null;
            }
        }
        ArrayList<Interval> newIntervals = new ArrayList<>();
        for (Interval i : intervals) {
            if (i != null) {
                newIntervals.add(i);
            }
        }
        Collections.sort(newIntervals);
        for (int i = 0; i < numberOfQueries; i++) {
            int a = readInt(), b = readInt();
            int low = 0, high = newIntervals.size() - 1, ans = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (newIntervals.get(mid).start > a) {
                    high = mid - 1;
                } else if (newIntervals.get(mid).start < a) {
                    low = mid + 1;
                    ans = mid;
                } else {
                    ans = mid;
                    break;
                }
            }
            if (ans == -1) {
                pr.println("N");
                continue;
            }
            if (newIntervals.get(ans).start <= a && newIntervals.get(ans).end >= b) {
                pr.println("Y");
            } else {
                pr.println("N");
            }
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
        return bufferedReader.readLine();
    }
}