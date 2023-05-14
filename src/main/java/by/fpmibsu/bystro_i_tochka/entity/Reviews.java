package by.fpmibsu.bystro_i_tochka.entity;

public class Reviews {
    public Reviews(User user, Food food, int id) {
        this.user = user;
        this.food = food;
        this.id = id;
    }

    public Reviews() {
        this.user = new User();
        this.food = new Food();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Food getFood() {
        return food;
    }

    public int getId() {
        return id;
    }

    private User user;

    private Food food;

    private int id;

}
