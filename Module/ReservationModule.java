package Module;

import Controller.ReservationController;
import Enums.ModuleType;

import java.util.Scanner;

public class ReservationModule extends ModuleBase{
    public ReservationModule(Scanner sc) {
        super(sc);
        controller = new ReservationController(sc);
    }

    @Override
    protected void init(){
        super.moduleType = ModuleType.RESERVATION;
    }

    @Override
    public void start(){
        System.out.println("예약 모듈 입니다");
        System.out.println("1. 메인  2.로그인  3.예약  4.개발자모드  0.종료");
        controller.SelectMenu();
    }

    @Override
    public void outModule(){
        System.out.println("예약 모듈 나감");
    }
}
