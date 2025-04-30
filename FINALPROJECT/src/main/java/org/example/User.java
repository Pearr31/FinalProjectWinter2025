package org.example;

public abstract class User {
   private String username;
   private String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public abstract void viewDashboard();
}
