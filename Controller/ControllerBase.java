package Controller;

import java.util.Scanner;
import java.util.ServiceConfigurationError;

public class ControllerBase {
    protected  int select = 0;
    protected Scanner sc = null;

    public ControllerBase(Scanner sc) {
        this.sc = sc;
    }

    public int SelectMenu(){return 0;}

    public String inputString(){return null;}
}
