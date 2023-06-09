package Controller;

import Enums.ModuleType;
import Module.ModuleManager;

import java.util.Scanner;

public class ReservationController extends ControllerBase{
    public ReservationController(Scanner sc) {
        super(sc);
    }

    @Override
    public int SelectMenu()
    {
        super.select = Integer.parseInt(sc.nextLine());
        return select;
    }

    @Override
    public String inputString(){
        String input = sc.nextLine();
        return input;
    }
}
