import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PhoneMicrowave {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int setting = Integer.parseInt(bufferedReader.readLine());
        Date time = format.parse(bufferedReader.readLine());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.HOUR, -1 * setting);
        System.out.println(format.format(calendar.getTime()));
    }
}