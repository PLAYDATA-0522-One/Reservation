package Module;

import Config.JdbcConnection;
import Controller.ReservationController;
import Data.Airpalne;
import Enums.ModuleType;
import View.ReservationView;
import com.mysql.cj.protocol.Resultset;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ReservationModule extends ModuleBase{

    private ReservationView view = new ReservationView();
    public ReservationModule(Scanner sc) {
        super(sc);
        controller = new ReservationController(sc);
    }

    private List<Airpalne> airplaneList = new ArrayList<>();

    @Override
    protected void init(){
        super.moduleType = ModuleType.RESERVATION;
    }

    @Override
    public void start(){
        view.printReservationMenu();
        switch (controller.SelectMenu()){
            case 1:
                //todo 조회
                //select 로 비행기 테이블 전체 조회
                showAirPlaneList();
                break;
            case 2:
                //todo 예약
                //티켓 만들어서 db에 insert
                break;
            case 0:
                ModuleManager.getInstance().changeModule(ModuleType.MAIN);
                break;
        }
    }

    private void showAirPlaneList(){
        //비행기 목록 clear
        airplaneList.clear();

        //db에서 읽어온다
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select * from airplane";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery(sql);
            while (rst.next()) {
                //컬럼 명으로 읽어와서 생성
                int id = rst.getInt("id");
                String name = rst.getString("airplane_name");
                Date departure_time = rst.getDate("departure_time");
                String start_destination = rst.getString("start_destination");
                String end_destination = rst.getString("end_destination");

                //리스트 추가
                Airpalne p = new Airpalne(id, name, departure_time, start_destination, end_destination);
                System.out.println(p.toString());
            }
        }
        catch (SQLException e) {
            System.out.println("show air plane error");
        }

        //db connection 닫기
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("sql close faill");
        }
    }

    private void reservationAirPlane_Step1(){
        view.printReservationAirPlan_askShowList();
        switch (controller.SelectMenu()){
            case 1:
                showAirPlaneList();
                break;
            case 2:
                reservationAirPlane_Step2();
                break;
            default:
                break;
        }
    }

    private void reservationAirPlane_Step2(){
        view.printInputAirPlanName();
        String airplanName = controller.inputString();
    }


    @Override
    public void outModule(){
        System.out.println("예약 모듈 나감");
    }
}
