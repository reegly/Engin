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


}
