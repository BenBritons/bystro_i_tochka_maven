package by.fpmibsu.bystro_i_tochka.entity;

public class Reviews {
    public Reviews(User user, String comment, int mark, Food food, int id) {
        this.user = user;
        this.comment = comment;
        this.mark = mark;
        this.food = food;
        this.id = id;
    }

    public Reviews(User user, String comment, int mark, Food food) {
        this.user = user;
        this.comment = comment;
        this.mark = mark;
        this.food = food;
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

    private String comment;
    private int mark;

    private Food food;

    private int id;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
