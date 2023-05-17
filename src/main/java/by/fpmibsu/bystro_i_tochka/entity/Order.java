package by.fpmibsu.bystro_i_tochka.entity;

import java.util.Date;
import java.util.List;

public class Order {

    private User user;
    private int id;
    private int addressID;

    private Date date;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Food> getOrder() {
        return order;
    }

    public void setOrder(List<Food> order) {
        this.order = order;
    }

    private List<Food> order;

    public Order(User user, int id, int addressID, Date date, List<Food> order) {
        this.user = user;
        this.id = id;
        this.addressID = addressID;
        this.date = date;
        this.order = order;
    }

    public Order() {
        this.user = new User();
        this.date = new Date();
    }

}
