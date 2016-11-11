public class UserData {
    private int size;
    private String login;
    private String password;
    private String resource;
    private String role;
    private String startDate;
    private String endDate;
    private String volumeResource;

    UserData() {
        this.login = null;
        this.password = null;
        this.resource = null;
        this.role = null;
        this.startDate = null;
        this.endDate = null;
        this.volumeResource = null;
    }

    public UserData setLogin(String login) {
        this.login = login;
        size++;
        return this;
    }

    public UserData setPassword(String password) {
        this.password = password;
        size++;
        return this;
    }

    public UserData setResource(String resource) {
        this.resource = resource;
        size++;
        return this;
    }

    public UserData setRole(String role) {
        this.role = role;
        size++;
        return this;
    }

    public UserData setStartDate(String startDate) {
        this.startDate = startDate;
        size++;
        return this;
    }

    public UserData setEndDate(String endDate) {
        this.endDate = endDate;
        size++;
        return this;
    }

    public UserData setVolumeResource(String volumeResource) {
        this.volumeResource = volumeResource;
        size++;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getResource() {
        return resource;
    }

    public String getRole() {
        return role;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getVolumeResource() {
        return volumeResource;
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return (login == null)
                && (password == null)
                && (role == null)
                && (resource == null)
                && (startDate == null)
                && (endDate == null)
                && (volumeResource == null);
    }
}
