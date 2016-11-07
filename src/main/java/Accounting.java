import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Accounting {
    private String startDate;
    private String endDate;
    private String value;
    private String user;
    private String role;


    Accounting(HashMap<String, String> hashMap) {
        this.startDate = hashMap.get("startDate");
        this.endDate = hashMap.get("endDate");
        this.value = hashMap.get("volumeResource");
        this.user = hashMap.get("login");
        this.role = hashMap.get("role");
    }


    public static boolean validTime(HashMap<String, String> hashMap) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            format.setLenient(false);
            format.parse(hashMap.get("startDate"));
            format.parse(hashMap.get("endDate"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean validValue(HashMap<String, String> hashMap) {
        int value;
        try {
            value = Integer.parseInt(hashMap.get("volume_resource"));
            if (value <= 0) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static long sesTime(HashMap<String, String> hashMap) {
        String t1 = hashMap.get("startDate");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date time1 = new Date();
        try {
            time1 = format.parse(t1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String t2 = hashMap.get("endDate");

        Date time2 = new Date();
        try {
            time2 = format.parse(t2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long time;
        time = time2.getTime() - time1.getTime();

        return Math.abs(time / 1000 / 60 / 60 / 24 + 1);
    }
}
