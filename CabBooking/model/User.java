package model;

public class User {
    private String userId;
    private String name;

    public User(String userId, String name){
        this.userId = userId;
        this.name = name; 
    }

    public String getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }
}
