import java.io.*;
import java.util.StringTokenizer;

//Template generated on 2021-11-10

public class Elevator {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer stringTokenizer;

    private static class Passenger {
        private final int timeWaited;
        private final int current;
        private final int destination;
        private boolean done = false;
        private int inElevator = -1;

        private Passenger(int timeWaited, int current, int destination) {
            this.timeWaited = timeWaited;
            this.current = current;
            this.destination = destination;
        }
    }


    public static void main(String[] args) throws IOException {
        int numberOfFloors = readInt();
        int timeToIncrement = readInt();
        int numberOfPassengers = readInt();
        Passenger[] passengers = new Passenger[numberOfPassengers];
        for (int i = 0; i < numberOfPassengers; i++) {
            passengers[i] = new Passenger(readInt(), readInt(), readInt());
        }
        int sum = 0;
        int currentTime = 0;
        int currentFloor = 0;
        boolean up = true;
        int passengersWaiting = numberOfPassengers;
        while (passengersWaiting > 0) {
            for (Passenger passenger : passengers) {
                if (passenger.done) {
                    continue;
                }
                if (currentFloor == passenger.current && currentTime >= passenger.timeWaited && passenger.inElevator == -1) {
                    passenger.inElevator = currentTime;
                    sum += currentTime - passenger.timeWaited;
                } else if (currentFloor == passenger.destination && passenger.inElevator != -1) {
                    sum += currentTime - passenger.inElevator;
                    passengersWaiting--;
                    passenger.done = true;
                }
            }
            if (currentFloor == 0) {
                up = true;
            } else if (currentFloor == numberOfFloors) {
                up = false;
            }
            if (up) {
                currentFloor++;
            } else {
                currentFloor--;
            }
            currentTime += timeToIncrement;
        }

        pr.println(sum);
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

    @SuppressWarnings("unused")
    private static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    @SuppressWarnings("unused")
    private static String readLine() throws IOException {
        return bufferedReader.readLine().trim();
    }
}