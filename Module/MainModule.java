package Module;

import Controller.MainController;
import Enums.ModuleType;
import View.MainView;

import java.util.Scanner;

public class MainModule extends ModuleBase{
    private MainView mainview = new MainView();
    public MainModule(Scanner sc) {
        super(sc);
        super.controller = new MainController(sc);
    }

    @Override
    protected void init(){
        super.moduleType = ModuleType.MAIN;
    }

    @Override
    public void start(){
        mainview.printMainMenu();

        switch (controller.SelectMenu()){
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

    @Override
    public void outModule(){
        System.out.println("메인 모듈 나감");
    }
}
