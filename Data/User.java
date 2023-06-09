package Data;

public class User {
    private int usernumber;
    private String userID;
    private String userPW;

    private String userName;


    public User(int usernumber, String id, String pw, String name) {
        this.usernumber = usernumber;
        this.userID = id;
        this.userPW = pw;
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }


    public int getUsernumber() {
        return usernumber;
    }

    public String getUserID() {
        return userID;
    }

    public String getPw() {
        return userPW;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='"+ userID + '\'' +
                ", pw='" + userPW + '\'' +
                '}';
    }
}
