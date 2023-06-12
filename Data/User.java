package Data;

public class User {
    //유저 고유 번호 primary key
    private int usernumber;
    //회원 가입 시 입력한 id
    private String userID;
    //비밀번호
    private String userPW;
    //유저 이름
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
