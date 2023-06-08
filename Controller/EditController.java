package Controller;

import java.util.Scanner;

import Enums.ModuleType;
import Module.ModuleManager;

public class MainController extends ControllerBase{
    public MainController(Scanner sc) {
        super(sc);
    }

    @Override
    public void SelectMenu()
    {
        super.select = Integer.parseInt(sc.nextLine());
        switch (select){
            case 1:
                ModuleManager.getInstance().changeModule(ModuleType.MAIN);
                break;
            case 2:
                ModuleManager.getInstance().changeModule(ModuleType.LOGIN);
                break;
            case 3:
                ModuleManager.getInstance().changeModule(ModuleType.RESERVATION);
                break;
            case 4:
                ModuleManager.getInstance().changeModule(ModuleType.EDIT);
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}
