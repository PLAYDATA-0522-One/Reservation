package Module;

import Enums.ModuleType;

import java.util.Scanner;

public class ModuleManager {
    private static Scanner sc = null;
    private static class LazyHolder {
        public static final ModuleManager INSTANCE = new ModuleManager();
    }
    public static ModuleManager getInstance(){
        return LazyHolder.INSTANCE;
    }

    private ModuleBase nowModule = null;

    public void initModuleManager(){
        sc = new Scanner(System.in);
        nowModule = new MainModule(sc);
    }

    public void start(){
        while (true){
            nowModule.start();
        }
    }

    public void changeModule(ModuleType type){

        nowModule.outModule();
        nowModule = null;

        switch (type){
            case MAIN -> {
                nowModule = new MainModule(sc);
            }
            case LOGIN -> {
                nowModule = new LoginModule(sc);
            }
            case RESERVATION -> {
                nowModule = new ReservationModule(sc);
            }
            case EDIT -> {
                nowModule = new EditModule(sc);
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
