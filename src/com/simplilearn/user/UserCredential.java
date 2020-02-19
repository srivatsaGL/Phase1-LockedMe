package com.simplilearn.user;

public class UserCredential {
            
            private String siteName;
            private String username;
            private String password;
            
            public UserCredential(){
                        
            }
            
            public UserCredential(String siteName, String username, String password){
                        this.siteName = siteName;
                        this.username = username;
                        this.password = password;
            }

            public void setSiteName(String siteName){
                        this.siteName = siteName;
            }
            
            public String getSiteName(){
                        return siteName;
            }
            
            public void setUsername(String username){
                        this.username = username;
            }
            
            public String getUsername(){
                        return username;
            }
            
            public void setPassword(String password){
                        this.password = password;
            }
            
            public String getPassword(){
                        return password;
            }
            
            @Override
            public String toString(){
                        
                        return "For the SiteID: "+ siteName+" The username is: "+ username + " and the password is: "+ password;
            }
}
