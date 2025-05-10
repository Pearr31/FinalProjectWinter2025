package org.example.foodsystem.user;

import java.util.Objects;

public abstract class User {
    protected String username;
    protected String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * abstract method to display user-specific dashboards
     */
    public abstract void viewDashboard();

    /**
     * allows user to login
     *
     * @param username provided username
     * @param password provided password
     * @return true if credentials match else false
     */
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    /**
     * logs out user
     */
    public void logout() {
        System.out.println(username + "logged out of system");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    public String getUsername() {
        return username;
    }
}
