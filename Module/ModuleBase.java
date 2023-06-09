package Module;

import Controller.ControllerBase;
import Enums.ModuleType;

import java.util.Scanner;

public class ModuleBase {
    public ModuleType getModuleType() {
        return moduleType;
    }

    protected ModuleType moduleType;
    protected Scanner sc;
    protected ControllerBase controller;

    public ModuleBase(Scanner sc) {
        this.sc = sc;
    }

    protected void init(){

    }

    public void start(){};

    public void outModule(){}
}
