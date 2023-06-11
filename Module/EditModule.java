package Module;

import Config.JdbcConnection;
import Controller.EditController;
import Data.Airpalne;
import Data.User;
import Enums.ModuleType;
import View.EditView;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class EditModule extends ModuleBase {

    private EditView view = new EditView();

    public EditModule(Scanner sc) {
        super(sc);
        controller = new EditController(sc);
    }

    private List<Airpalne> airpalneList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);


    @Override
    protected void init() {
        super.moduleType = ModuleType.EDIT;
    }

    @Override
    public void start() {
        view.printDevelopMenu();
        switch (controller.SelectMenu()) {
            case 1:
//                TODO: 비행기 데이터 조회
                getAirPlaneList_by_Database();
                showAirplaneList();

                break;
            case 2:
//                TODO: 비행기 데이터 추가
                insertAirplane();
                break;
            case 3:
//                TODO: 비행기 데이터 삭제
                showAirplaneList();
                deleteAirplane();
                break;
            case 4:
//                TODO: 유저 정보 조회
                getUserList_by_Database();
                showUserList();

                break;
            case 5:
//                TODO: 유저 정보 추가
                insertUser();
                break;
            case 6:
//                TODO: 유저 정보 삭제
                showUserList();
                deleteUser();
                break;
            case 0:
                ModuleManager.getInstance().changeModule(ModuleType.MAIN);
                break;
        }
    }

    private void getAirPlaneList_by_Database() {
        // 비행기 목록 clear
        airpalneList.clear();

        //db에서 읽어온다
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select * from airplane";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery(sql);
            while (rst.next()) {
                // 컬럼명으로 읽어와서 생성
                int id = rst.getInt("id");
                String airplane_name = rst.getString("airplane_name");
                Date departure_time = rst.getDate("departure_time");
                String start_destination = rst.getString("start_destination");
                String end_destination = rst.getString("end_destination");

                // 리스트 추가
                Airpalne p = new Airpalne(id, airplane_name, departure_time, start_destination, end_destination);
                airpalneList.add(p);
            }
        } catch (SQLException e) {
            System.out.println("show air plane error");
        }

        // db connection 닫기
        try {
            conn.close();
            ;
        } catch (SQLException e) {
            System.out.println("sql close fail");
        }
    }

    private void insertAirplane() {
        // db에 비행기 정보 임의로 insert
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "insert into airplane(airplane_name, departure_time, start_destination, end_destination)\n"
                + "values (?, ?, ?, ?)";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            // 비행기 이름, 출발, 도착지 입력 받기
            System.out.println("비행기 이름 입력 >> ");
            String airplaneName = sc.nextLine();
            System.out.println("출발지 입력 >> ");
            String startDestination = sc.nextLine();
            System.out.println("도착지 입력 >> ");
            String endDestination = sc.nextLine();

            pst.setString(1, airplaneName);
            pst.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
            pst.setString(3, startDestination);
            pst.setString(4, endDestination);

            if (pst.executeUpdate() == 0) {
                System.out.println("insert airplane error");
            } else {
                view.printSuccess();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("sql close fail");
        }
    }

    private void deleteAirplane() {
        // 비행기 이름으로 delete
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "delete from airplane where airplane_name = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            // 비행기 이름 받기
            System.out.println("비행기 이름 입력 >> ");
            String airplaneName = sc.nextLine();
            pst.setString(1, airplaneName);

            if (pst.executeUpdate() == 0) {
                System.out.println("delete airplane error");
            } else {
                view.printSuccess();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("sql close fail");
        }
    }

    private void showAirplaneList() {
        for (int i = 0; i < airpalneList.size(); i++) {
            System.out.println(airpalneList.get(i).toString());
        }
    }

    private void getUserList_by_Database() {
        // 유저 목록 clear
        userList.clear();

        // db에서 읽어온다
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select * from user";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery(sql);

            while (rst.next()) {
                int id = rst.getInt("id");
                String username = rst.getString("username");
                String password = rst.getString("password");
                String name = rst.getString("name");

                // 리스트 추가
                User u = new User(id, username, password, name);
                userList.add(u);
            }
        } catch (SQLException e) {
            System.out.println("show user error");
        }

        // db connection 닫기
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("sql close fail");
        }

    }

    private void insertUser() {
        // db에 유저 정보 임의로 insert
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "insert into user(username, password, name)\n"
                + "values(?, ?, ?)";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            // 아이디, 패스워드, 이름 받기
            System.out.println("아이디 입력 >> ");
            String username = sc.nextLine();
            System.out.println("패스워드 입력 >> ");
            String password = sc.nextLine();
            System.out.println("이름 입력 >> ");
            String name = sc.nextLine();

            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, name);

            if (pst.executeUpdate() == 0) {
                System.out.println("insert user error");
            } else {
                view.printSuccess();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("sql close fail");
        }
    }

    private void deleteUser() {
        // 유저 아이디로 delete
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "delete from user where username = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            // 유저 아이디 입력
            System.out.println("유저 아이디 입력 >> ");
            String username = sc.nextLine();
            pst.setString(1, username);

            if (pst.executeUpdate() == 0) {
                System.out.println("delete user error");
            } else {
                view.printSuccess();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("sql close fail");
        }
    }

    private void showUserList() {
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).toString());
        }
    }

    @Override
    public void outModule() {

    }
}
