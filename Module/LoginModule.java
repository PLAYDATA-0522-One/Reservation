package Module;

import Controller.LoginController;
import Controller.MainController;
import Enums.ModuleType;

import java.util.Scanner;

public class LoginModule extends ModuleBase{
    public LoginModule(Scanner sc) {
        super(sc);
        super.controller = new LoginController(sc);
    }

    @Override
    protected void init(){
        super.moduleType = ModuleType.LOGIN;
    }

    @Override
    public void start(){
        System.out.println("로그인 모듈 입니다");
        System.out.println("1. 메인  2.로그인  3.예약  4.개발자모드  0.종료");
        controller.SelectMenu();
    }

    @Override
    public void outModule(){
        System.out.println("로그인 모듈 나감");
    }
}
