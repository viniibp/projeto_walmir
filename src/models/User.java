package models;

public class User{
        private final String username;
        private final String password;
        private final int userType;
        
        public User(String user, String password, int userType){
            this.username = user;
            this.password = password;
            this.userType = userType;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public int getUserType() {
            return userType;
        }

    }
    

