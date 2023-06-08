package Data;

public class User {
    private int usernumber;
    private String userID;
    private String pw;

    public User(int usernumber, String userID, String pw) {
        this.usernumber = usernumber;
        this.userID = userID;
        this.pw = pw;
    }

    public int getUsernumber() {
        return usernumber;
    }

    public String getUserID() {
        return userID;
    }

    public String getPw() {
        return pw;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
