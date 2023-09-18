import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TrafficLight {
    final int timeRed;
    final int timeGreen;

    TrafficLight(int timeRed, int timeGreen) {
        this.timeRed = timeRed;
        this.timeGreen = timeGreen;
    }
}

public class Semafori {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = bufferedReader.readLine().split(" ");
        int numberOfTrafficLights = Integer.parseInt(firstLine[0]);
        int roadLength = Integer.parseInt(firstLine[1]);

        TrafficLight[] trafficLights = new TrafficLight[roadLength];
        for (int i = 0; i < numberOfTrafficLights; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            trafficLights[Integer.parseInt(input[0])] = new TrafficLight(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
        }
        int time = roadLength;
        int timeSpentWaiting = 0;
        for (int i = 0; i < roadLength; i++) {
            TrafficLight trafficLight = trafficLights[i];
            if (trafficLight != null) {
                boolean red;
                int e = (i + timeSpentWaiting) % (trafficLight.timeRed + trafficLight.timeGreen);
                red = e < trafficLight.timeRed;
                 if (red) {
                    time += trafficLight.timeRed - e;
                    timeSpentWaiting += trafficLight.timeRed - e;
                }
            }
        }
        System.out.println(time);
    }
}