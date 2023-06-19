package Config.Dao;

public class UserDto {

    public class User {

        public User(Integer id, String username, String password, String name, String createAt) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.name = name;
            this.createAt = createAt;
        }

        private Integer id;

        private String username;

        private String createAt;

        public Integer getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getName() {
            return name;
        }

        private String password;

        private String name;
    }
}
