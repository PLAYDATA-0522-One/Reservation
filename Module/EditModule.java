package Module;

import Controller.EditController;
import Enums.ModuleType;
import View.EditView;
import View.LoginView;

import java.util.Scanner;

public class EditModule extends ModuleBase{
    public EditModule(Scanner sc) {
        super(sc);
        controller = new EditController(sc);
    }

    @Override
    protected void init(){
        super.moduleType = ModuleType.EDIT;
    }

    @Override
    public void start(){
        EditView editView = new EditView();
        EditView.printeditView();
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
        System.out.println("에딧 모듈 나감");
    }
}
