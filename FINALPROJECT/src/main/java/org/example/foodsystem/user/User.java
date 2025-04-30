package org.example.foodsystem.user;

public abstract class User {
   private String username;
   private String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public abstract void viewDashboard();

    public String getUsername() {
        return username;
    }

}
