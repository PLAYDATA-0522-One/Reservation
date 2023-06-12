package Controller;

import Enums.ModuleType;
import Module.ModuleManager;

import java.util.Scanner;

public class LoginController extends ControllerBase{ //컨트롤러 베이스 클래스를 확장하여 LoginController 클래스에서 사용함
    public LoginController(Scanner sc) {
        super(sc);
    } //컨트롤러에서 입력받은 sc를 호출하여 초기화 한 후, LoginController 클래스의 매개변수로 사용함

    @Override
    public int SelectMenu()
    {
        super.select = Integer.parseInt(sc.nextLine());
        return select;
    }
}
