package Data;

import javax.xml.crypto.Data;

public class DataManager {
    private static class LazyHolder {
        public static final DataManager INSTANCE = new DataManager();
    }
    public static DataManager getInstance(){
        return LazyHolder.INSTANCE;
    }

    //로그인 한 회원 정보
    private User user = null;



}
