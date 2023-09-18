import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrivalTime {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] start = bufferedReader.readLine().split(":");
        int hour = Integer.parseInt(start[0]);
        int minute = Integer.parseInt(start[1]);
        int time = 120;
        int timeInRush;
        if (hour == 6 || (hour == 5 && minute > 0)) {
            //timeInRush = hour * 60 + minute - 300;
            timeInRush = 120 - (420 - (hour * 60 + minute));
            time = timeInRush * 2 + (420 - (hour * 60 + minute));
            if (time + minute + hour * 60 > 600) {
               // System.out.println((420 - (hour * 60 + minute)) + " " + 2*timeInRush + " " + (time + minute + hour * 60 - 600));
                time = (420 - (hour * 60 + minute)) + 2*timeInRush + (time + minute + hour * 60 - 600 - 30);
            }
        } else if (hour == 14 || (hour == 13 && minute > 0)) {
           // timeInRush = hour * 60 + minute - 780;
            timeInRush = 120 - (900 - (hour * 60 + minute));
            time = timeInRush * 2 + (900 - (hour * 60 + minute));
        } else if (hour == 7 || hour == 8 || hour == 9) {
            timeInRush = 600 - 60 * hour - minute;
            time = (120 - timeInRush / 2) + timeInRush;
        } else if (hour == 15 || hour == 16 || hour == 17 || hour == 18) {
            timeInRush = 1140 - hour * 60 - minute;
            time = (120 - timeInRush / 2) + timeInRush;
        }


        minute += time;
        hour += minute / 60;
        minute = minute % 60;
        if (hour > 23) {
            hour = hour % 24;
        }
        System.out.printf("%02d:%02d", hour, minute);

    }
}