package mobiledoctor.parvez.com.mobiledoctor.userClass;

public class UserPojoclass {

    private String fullName;
    private String userEmail;
    private String userPassword;
    private String userPhoneNo;
    private int age;
    private String userGander;

    public UserPojoclass(String fullName, String userEmail, String userPassword, String userPhoneNo, int age, String userGander) {
        this.fullName = fullName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhoneNo = userPhoneNo;
        this.age = age;
        this.userGander = userGander;
    }

    public UserPojoclass() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserGander() {
        return userGander;
    }

    public void setUserGander(String userGander) {
        this.userGander = userGander;
    }
}
