package by.fpmibsu.bystro_i_tochka.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private User user;
    private int id;
    private Address address;
    private ArrayList<Food> order;
    private Date date;

    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }

    public Order(User user, int id, Address address, ArrayList<Food> order, Date date) {
        this.user = user;
        this.id = id;
        this.address = address;
        this.order = order;
        this.date = date;
    }

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


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Food> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Food> order) {
        this.order = order;
    }

    public Order(User user, int id, int addressID, Date date, ArrayList<Food> order) {
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
