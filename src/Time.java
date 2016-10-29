import java.time.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Time {
    public static Date getTime() {
        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        return time;
    }

    public static String sestime(Date time1) {
        long time;
        Date cur = new Date();
        time = cur.getTime() - time1.getTime();
        long sec,min,hour;
        hour = time/1000/60/60;
        min = (time - hour*1000*60*60) /1000/60;
        sec = (time-hour*1000*60*60-min*1000*60)/1000;
        String t = "Session time:  " + hour + ':'+min+":"+sec;
        return t;
    }
}
