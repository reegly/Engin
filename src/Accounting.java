import java.util.*;
import java.text.SimpleDateFormat;

public class Accounting {
    private String start_date;
    private String end_date;
    private String value;
    private String user;
    private String role;



    Accounting(HashMap<String, String> hashMap)
    {
        this.start_date=hashMap.get("start_date");
        this.end_date=hashMap.get("end_date");
        this.value=hashMap.get("volume_resource");
        this.user=hashMap.get("login");
        this.role=hashMap.get("role");
    }



    public static boolean validtime(HashMap<String, String> hashMap) {



        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            format.setLenient(false);
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
