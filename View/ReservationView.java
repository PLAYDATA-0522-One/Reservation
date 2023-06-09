package View;

public class ReservationView {

    public void printOutLineAirplane(){
        System.out.println("========================");
    }

    public void printReservationMenu() {
        printOutLineAirplane();
        System.out.println("항    공    편    예    약");
        printOutLineAirplane();
        System.out.println("1. 조회  2. 예약  0.이전 메뉴");
    }

    public void printReservationAirPlan_askShowList(){
        System.out.println("비행기 목록을 확인 하시겠습니까?");
        System.out.println("1. 확인  2. 바로 예약");
    }

    public void printInputAirPlanName(){
        System.out.println("비행기 이름을 입력해 주세요.");
    }

    public void printSuccessAirPlane(){
        System.out.println("예약이 성공적으로 완료 되었습니다.");
    }

}
