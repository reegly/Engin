import java.util.*;
import java.text.SimpleDateFormat;

public class Accounting {
   /* private Date Date1;
    private Date Date2;
    private double val;*/

    /*Accounting(String s1,String s2, double val)
    {
        this.val=val;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.Date1 = format.parse(s1);
            this.Date2 = format.parse(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static boolean validtime(HashMap<String, String> hashMap) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            format.parse(hashMap.get("start_date"));
            format.parse(hashMap.get("end_date"));

        } catch (Exception e) {
            // e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean validvalue(HashMap<String, String> hashMap) {
        int val;
        try {
            val = Integer.parseInt(hashMap.get("volume_resource"));
            if (val <= 0) {
                return false;
            }
        } catch (Exception e) {
            // e.printStackTrace();
            return false;
        }

        return true;
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

        return Math.abs(time / 1000 / 60 / 60 / 24 + 1);
    }
}
