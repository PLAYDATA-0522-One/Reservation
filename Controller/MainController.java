package Controller;

import java.util.Scanner;

import Enums.ModuleType;
import Module.ModuleManager;

public class MainController extends ControllerBase{
    public MainController(Scanner sc) {
        super(sc);
    }

    @Override
    public int SelectMenu()
    {
        super.select = Integer.parseInt(sc.nextLine());
        return select;
    }
}
