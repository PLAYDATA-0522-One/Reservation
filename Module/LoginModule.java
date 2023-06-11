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
    private final Scanner sc;

    public LoginModule(Scanner sc) {
        super(sc);
        super.controller = new LoginController(sc);
        this.sc = sc;
    }
    private boolean login() {
        System.out.println("로그인");
        System.out.println("ID를 입력해주세요: ");
        String username = sc.nextLine();
        if (username.trim().isEmpty() ) {
            System.out.println("로그인 실패, 잘못된 입력입니다.");
            return false;
        }
        System.out.println("PW를 입력해주세요: ");
        String password = sc.nextLine();

        if (password.trim().isEmpty()) {
            System.out.println("로그인 실패, 잘못된 입력입니다.");
            return false;
        }


        Connection conn = new JdbcConnection().getJdbc();
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        Integer id0;
        String name0;
        String username0;
        String password0;

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, username);
            psmt.setString(2, password);
            ResultSet resultSet = psmt.executeQuery();

            if (resultSet.next()) {
                id0 = resultSet.getInt("id");
                username0 = resultSet.getString("username");
                password0 = resultSet.getString("password");
                name0 = resultSet.getString("name");

                User user = new User(id0, username0, password0, name0);
                System.out.println(username + " " + name0 + " 환영해요");
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
        String validId = "username";
        String validPassword = "password";

        return id.equals(validId) && pw.equals(validPassword);
    }

    private void signup() {
        Connection conn = new JdbcConnection().getJdbc();
        Integer idKey1 = null;
        String name1 = null;

        String selectSql = "SELECT username FROM user WHERE username = ?";
        String insertSql = "INSERT INTO user(username, password, name) VALUES (?, ?, ?)";

        System.out.println("회원가입");
        System.out.println("Please enter ID: ");
        String username = sc.nextLine();
        System.out.println("Please enter PW: ");
        String password = sc.nextLine();
        System.out.println("Please enter a name: ");
        String name = sc.nextLine();;

        if (!isPasswordValid(password)) {
            System.out.println("ERROR: Password must contain at least one special character and one uppercase letter.");
            return;
        }else{System.out.println("Available Password!");
        }

        try {
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            selectStmt.setString(1, username);
            ResultSet resultSet = selectStmt.executeQuery();

            if (resultSet.next()) {
                System.out.println("ERROR: User already exists!");
                return;
            }

            // Create a new user
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setString(1, username); // username == id
            insertStmt.setString(2, password);
            insertStmt.setString(3, name);
            int rowsAffected = insertStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Registration Successful!");

            } else {
                System.out.println("ERROR: Registration Failed!");
                return;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean isPasswordValid(String password) {
        // Password must contain at least one special character and one uppercase letter
        String specialCharacters = "!@#$%^&*()-_=+[{]};:'\",<.>/?";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        boolean hasSpecialCharacter = false;
        boolean hasUppercaseLetter = false;

        for (char c : password.toCharArray()) {
            if (specialCharacters.contains(String.valueOf(c))) {
                hasSpecialCharacter = true;
            } else if (uppercaseLetters.contains(String.valueOf(c))) {
                hasUppercaseLetter = true;
            }

            // Break the loop if both requirements are met
            if (hasSpecialCharacter && hasUppercaseLetter) {
                break;
            }
        }

        return hasSpecialCharacter && hasUppercaseLetter;
    }



    @Override
    protected void init(){
        super.moduleType = ModuleType.LOGIN;
    }

    @Override
    public void start(){
        LoginView loginView = new LoginView();
        LoginView.printloginView();
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
