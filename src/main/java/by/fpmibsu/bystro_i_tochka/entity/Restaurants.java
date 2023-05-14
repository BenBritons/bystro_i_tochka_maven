package by.fpmibsu.bystro_i_tochka.entity;

import java.util.Calendar;

public class Restaurants {

    public Restaurants(Address location, MyCalendar workTime) {
        this.location = location;
        this.workTime = workTime;
    }
    public Restaurants() {
        this.location = new Address();
        this.workTime = new MyCalendar();
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public MyCalendar getWorkTime() {
        return workTime;
    }

    public void setWorkTime(MyCalendar workTime) {
        this.workTime = workTime;
    }

    private Address location;

    private MyCalendar workTime;
}
