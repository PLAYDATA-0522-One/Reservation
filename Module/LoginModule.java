package Module;

import Config.JdbcConnection;
import Controller.LoginController;
import Data.User;
import Enums.ModuleType;
import View.LoginView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginModule extends ModuleBase{
    private Scanner sc;

    public LoginModule(Scanner sc) {
        super(sc);
        super.controller = new LoginController(sc);
        this.sc = sc;
    }
    private boolean login() {
        System.out.println("로그인");
        System.out.println("ID를 입력해주세요: ");
        String id = sc.nextLine();
        System.out.println("PW를 입력해주세요: ");
        String pw = sc.nextLine();

        Connection conn = new JdbcConnection().getJdbc();
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        Integer idKey = null;
        String name0 = null;

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);
            psmt.setString(2, pw);
            ResultSet resultSet = psmt.executeQuery();

            if (resultSet.next()) {
                idKey = resultSet.getInt("id");
                name0 = resultSet.getString("name");

                User user = new User(idKey, id, pw, name0);
                System.out.println(idKey + " " + name0 + " 환영해요");
                return true;
            } else {
                System.out.println("로그인 실패, 유효하지 않은 ID 입니다.");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private boolean verifyCredentials(String id, String pw) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select * from users" + " where username = ? and password = ?";
        String validId = "id";
        String validPassword = "pw";

        return id.equals(validId) && pw.equals(validPassword);
    }



    private void signup() {
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "insert into users(id, pw, username)\n" +
                "values (?, ?, ?);\t";

        System.out.println("회원가입");
        System.out.println("ID를 입력해주세요: ");
        String id = sc.nextLine();
        System.out.println("PW를 입력해주세요: ");
        String password = sc.nextLine();
        System.out.println("이름을 입력해주세요: ");
        String username = sc.nextLine();
        System.out.println("회원가입 성공!");
        int number =0;
        User newUser = new User(number, id, password, username);
        number = newUser.getUsernumber()+1;
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, newUser.getUserID());
            psmt.setString(2, newUser.getPw());
            psmt.setString(3, newUser.getUserName());
            int rowsAffected = psmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("등록 완료!");
            } else {
                System.out.println("ERROR: 등록 실패.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    protected void init(){
        super.moduleType = ModuleType.LOGIN;
    }

    @Override
    public void start(){
        LoginView loginView = new LoginView();
        loginView.printloginView();
        switch (controller.SelectMenu()){
            case 1:
                //todo login
                login();
                break;
            case 2:
                //todo signup
                signup();
                break;
            case 0:
                ModuleManager.getInstance().changeModule(ModuleType.MAIN);
                break;
        }
    }

    @Override
    public void outModule(){
        System.out.println("로그인 모듈 나감");
    }
}
