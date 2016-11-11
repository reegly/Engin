import java.text.SimpleDateFormat;


public class Accounting {
    private String startDate;
    private String endDate;
    private String value;
    private String user;
    private String role;


    Accounting(UserData userData) {
        this.startDate = userData.getStartDate();
        this.endDate = userData.getEndDate();
        this.value = userData.getVolumeResource();
        this.user = userData.getLogin();
        this.role = userData.getRole();
    }


    public static boolean validTime(UserData userData) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            format.setLenient(false);
            format.parse(userData.getStartDate());
            format.parse(userData.getEndDate());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean validValue(UserData userData) {
        int value;
        try {
            value = Integer.parseInt(userData.getVolumeResource());
            if (value <= 0) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
