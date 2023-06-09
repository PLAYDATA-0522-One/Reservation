package Module;

import Config.JdbcConnection;
import Controller.ReservationController;
import Data.Airpalne;
import Data.DataManager;
import Data.User;
import Enums.ModuleType;
import View.ReservationView;

import java.sql.*;
import java.util.ArrayList;
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
                getAirPlaneList_by_Database();
                showAirplaneList();
                break;
            case 2:
                //todo 예약
                //티켓 만들어서 db에 insert
                reservationAirPlane_Step1();
                break;
            case 0:
                ModuleManager.getInstance().changeModule(ModuleType.MAIN);
                break;
        }
    }

    private void getAirPlaneList_by_Database(){
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
                airplaneList.add(p);
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
                getAirPlaneList_by_Database();
                showAirplaneList();
                reservationAirPlane_Step2();
                break;
            case 2:
                reservationAirPlane_Step2();
                break;
            default:
                break;
        }
    }

    private void reservationAirPlane_Step2(){
        //비행기 이름 입력
        view.printInputAirPlanName();
        String airplanName = controller.inputString();

        //티켓 생성 전에 비행기 리스트 다시 갱신 (db 로부터 불러오기)
        getAirPlaneList_by_Database();

        //입력 받은 비행기 이름 기준으로 찾는다
        Airpalne air = findAirPlane(airplanName);

        //air 가 있으면 티켓 생성 없으면 애러 메시지
        if (air == null){
            view.printFindAirplaneError();
        }
        else{

            //db에 티켓 insert
            Connection conn = new JdbcConnection().getJdbc();

            String sql = "insert into ticket (userid, airplane_name, departure_time, start_destination, end_destination)\n"
                    + "values (?, ?, ?, ?, ?)";

            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, DataManager.getInstance().getUser().getUserID());
                pst.setString(2, air.getAirplaneName());
                pst.setDate(3, air.getDepartureTime());
                pst.setString(4, air.getStartDestination());
                pst.setString(5, air.getEndDestination());

                if(pst.executeUpdate() == 0){
                    System.out.println("insert ticket error");
                }
                else{
                    view.printSuccessAirPlane();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("sql close faill");
            }
        }
    }

    private void showAirplaneList(){
        for (int i = 0; i < airplaneList.size(); i++) {
            System.out.println(airplaneList.get(i).toString());
        }
    }

    private Airpalne findAirPlane(String name){
        for (int i = 0; i < airplaneList.size(); i++) {
            if (airplaneList.get(i).getAirplaneName().equals(name))
                return airplaneList.get(i);
        }

        return null;
    }


    @Override
    public void outModule(){
        System.out.println("예약 모듈 나감");

    }
}
