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

    /**
     * abstract method to display user-specific dashboards
     */
    public abstract void viewDashboard();

    /**
     * allows user to login
     * @param username provided username
     * @param password provided password
     * @return true if credentials match else false
     */
    public boolean login(String username, String password) {
        //TODO implement logic to login
        return false;
    }

    public String getUsername() {
        return username;
    }

}
