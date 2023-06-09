package Controller;

import Enums.ModuleType;
import Module.ModuleManager;

import java.util.Scanner;

public class LoginController extends ControllerBase{
    public LoginController(Scanner sc) {
        super(sc);
    }

    @Override
    public int SelectMenu()
    {
        super.select = Integer.parseInt(sc.nextLine());
        return select;
    }
}
