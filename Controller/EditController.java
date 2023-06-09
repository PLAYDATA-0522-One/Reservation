package Controller;

import Enums.ModuleType;
import Module.ModuleManager;

import java.util.Scanner;

public class EditController extends ControllerBase{
    public EditController(Scanner sc) {
        super(sc);
    }

    @Override
    public int SelectMenu()
    {
        super.select = Integer.parseInt(sc.nextLine());


        return select;
    }
}
