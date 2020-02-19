package com.simplilearn.user;

public class UserRegistration {
            
            private String username;
            private String password;
            
            public UserRegistration(){
                        
            }
            
            public UserRegistration(String username, String password){
                        this.username = username;
                        this.password = password;
            
            }

            public String getUsername() {
                        return username;
            }

            public void setUsername(String username) {
                        this.username = username;
            }

            public String getPassword() {
                        return password;
            }

            public void setPassword(String password) {
                        this.password = password;
            }
            
            @Override
            public String toString(){
                        
                        return "The username is: "+ username + "and the password is: "+ password;
            }
}
