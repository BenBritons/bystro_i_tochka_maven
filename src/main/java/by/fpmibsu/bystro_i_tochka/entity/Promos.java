package by.fpmibsu.bystro_i_tochka.entity;

public class Promos {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    private int id;

    public Promos(int id, Food food, int discount) {
        this.id = id;
        this.food = food;
        this.discount = discount;
    }
    public Promos() {

    }

    private Food food;

    private int discount;
}
