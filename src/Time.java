import java.time.*;
<<<<<<< Updated upstream
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
=======
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Time {
   /* public static Date getTime(HashMap<String, String> hashMap) {
        String t = hashMap.get("start_date");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date time1 = new Date();
        try {
            time1 = format.parse(t);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return time1;
    }*/


    public static long sestime(HashMap<String, String> hashMap) {
        String t = hashMap.get("start_date");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date time1 = new Date();
        try {
            time1 = format.parse(t);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String t2 = hashMap.get("end_date");

        Date time2 = new Date();
        try {
            time2 = format.parse(t);
        } catch (Exception e) {
            e.printStackTrace();
        }






        long time;
        Date cur = new Date();
        time = time2.getTime() - time1.getTime();

        return time/1000/60/24;
>>>>>>> Stashed changes
    }
}
