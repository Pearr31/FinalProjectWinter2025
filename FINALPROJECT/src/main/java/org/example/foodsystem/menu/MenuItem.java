package org.example.foodsystem.menu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MenuItem implements Comparable<MenuItem> {
    private String name;
    private String genre;
    private double price;

    public MenuItem(String name, String genre, double price) {
        this.name = name;
        this.genre = genre;
        this.price = price;
    }


    @Override
    public int compareTo(MenuItem o) {
        int genreCompare = this.genre.compareTo(o.genre);
        if (genreCompare != 0) return genreCompare;
        return this.name.compareTo(o.name);
    }

    public static class PriceComparator implements Comparator<MenuItem> {
        @Override
        public int compare(MenuItem o1, MenuItem o2) {
            return Double.compare(o1.getPrice(), o2.getPrice());
        }
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Double.compare(price, menuItem.price) == 0 && Objects.equals(name, menuItem.name) && Objects.equals(genre, menuItem.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, genre);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
