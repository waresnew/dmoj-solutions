import java.io.*;
import java.util.StringTokenizer;

//Template generated on 3/14/2022

public class PackingMicrowaves {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        long numberOfMicrowaves = readLong(), microX = readLong(), microY = readLong(), microZ = readLong(), truckX = readLong(), truckY = readLong(), truckZ = readLong();
        long[][] dims = new long[6][3];
        dims[0] = new long[]{microX, microY, microZ};
        dims[1] = new long[]{microX, microZ, microY};
        dims[2] = new long[]{microZ, microY, microX};
        dims[3] = new long[]{microZ, microX, microY};
        dims[4] = new long[]{microY, microX, microZ};
        dims[5] = new long[]{microY, microZ, microX};
        long answer = 0;
        for (long[] dim : dims) {
            long fit = Math.max(answer, (truckX / dim[0]) * (truckY / dim[1]) * (truckZ / dim[2]));
            answer = Math.max(fit, answer);
        }
        pr.println(answer == 0 ? "SCAMMED" : (long) Math.ceil((double) numberOfMicrowaves / (double) answer));
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