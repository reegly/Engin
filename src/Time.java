
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Time {
    public static Date getTime(HashMap<String, String> hashMap) {
        String t = hashMap.get("start_date");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date time1 = new Date();
        try {
            time1 = format.parse(t);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return time1;
    }


    public static long sestime(HashMap<String, String> hashMap) {
        String t1 = hashMap.get("start_date");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date time1 = new Date();
        try {
            time1 = format.parse(t1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String t2 = hashMap.get("end_date");

        Date time2 = new Date();
        try {
            time2 = format.parse(t2);
        } catch (Exception e) {
            e.printStackTrace();
        }


        long time;
        Date cur = new Date();
        time = time2.getTime() - time1.getTime();

        return time / 1000 / 60 / 60 / 24;
    }
}
