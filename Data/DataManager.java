package Data;

import javax.xml.crypto.Data;

//Database 에서 가져온 데이터들을 관리하기 위한 manager
public class DataManager {
    private static class LazyHolder {
        public static final DataManager INSTANCE = new DataManager();
    }
    public static DataManager getInstance(){
        return LazyHolder.INSTANCE;
    }

    //로그인 한 회원 정보
    private User user = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
