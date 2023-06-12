package Module;

import Controller.ControllerBase;
import Enums.ModuleType;

import java.util.Scanner;

public class ModuleBase {
    public ModuleType getModuleType() {
        return moduleType;
    }

    //모듈 타입
    protected ModuleType moduleType;
    //컨트롤러에 넘겨주기 위한 스케너
    protected Scanner sc;
    //컨트롤러 (입력) 클래스
    protected ControllerBase controller;

    //모듈 생성시 스케너 넘겨줘야 함
    public ModuleBase(Scanner sc) {
        this.sc = sc;
    }

    protected void init(){

    }

    public void start(){};

    public void outModule(){}
}
