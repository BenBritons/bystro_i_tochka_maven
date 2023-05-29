package by.fpmibsu.bystro_i_tochka.entity;

import java.util.Objects;

public class Food {

    public Food(int id, double price) {
        this.id = id;
        this.price = price;
    }
    public Food() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    private int id;

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return id == food.id && Double.compare(food.price, price) == 0 && Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Food(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    private double price;
    private String name;

}
