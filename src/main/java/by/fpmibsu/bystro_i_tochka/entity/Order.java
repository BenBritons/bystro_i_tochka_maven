package by.fpmibsu.bystro_i_tochka.entity;

import java.util.Date;
import java.util.List;

public class Order {

    private User user;
    private int id;

    private Date date;

    private List<Food> order;

    public Order(User user, int id, Date date, List<Food> order) {
        this.user = user;
        this.id = id;
        this.date = date;
        this.order = order;
    }

    public Order() {
        this.user = new User();
        this.date = new Date();
    }

}
