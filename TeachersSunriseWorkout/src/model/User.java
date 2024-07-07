package model;

public class User {
    private String username;
    private static final String PASSWORD = "4ourHealth";

    public User(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;

    }
    public static String getPassword(){
        return PASSWORD;
    }
}
