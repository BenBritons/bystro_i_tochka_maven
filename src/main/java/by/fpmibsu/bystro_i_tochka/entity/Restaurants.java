package by.fpmibsu.bystro_i_tochka.entity;

import java.time.DayOfWeek;
import java.time.LocalTime;;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Restaurants {

    public Restaurants(int id, Address location, LocalTime workTimeStart, LocalTime workTimeEnd) {
        this.id = id;
        this.location = location;
        this.workTimeStart = workTimeStart;
        this.workTimeEnd = workTimeEnd;
    }

    public Restaurants(int id, Address location, String name, LocalTime workTimeStart, LocalTime workTimeEnd, DayOfWeek...weekendDays) {
        this.id = id;
        this.location = location;
        this.name = name;
        this.workTimeStart = workTimeStart;
        this.workTimeEnd = workTimeEnd;
        this.weekends = new HashSet<>();
        Collections.addAll(weekends, weekendDays);
    }


    public Restaurants(int id) {
        this.id = id;
        this.location = new Address();
    }
    public Restaurants() {

    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public LocalTime getWorkTimeStart() {
        return workTimeStart;
    }

    public void setWorkTimeStart(LocalTime workTimeStart) {
        this.workTimeStart = workTimeStart;
    }

    public LocalTime getWorkTimeEnd() {
        return workTimeEnd;
    }

    public void setWorkTimeEnd(LocalTime workTimeEnd) {
        this.workTimeEnd = workTimeEnd;
    }

    public HashSet<DayOfWeek> getWeekends() {
        return weekends;
    }

    public void setWeekends(HashSet<DayOfWeek> weekends) {
        this.weekends = weekends;
    }

    private int id;
    private Address location;
    private String name;

    private LocalTime workTimeStart;
    private LocalTime workTimeEnd;

    private HashSet<DayOfWeek> weekends;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public Restaurants(int id, Address location, String name, LocalTime workTimeStart, LocalTime workTimeEnd, HashSet<DayOfWeek> weekends, ArrayList<Food> foods) {
        this.id = id;
        this.location = location;
        this.name = name;
        this.workTimeStart = workTimeStart;
        this.workTimeEnd = workTimeEnd;
        this.weekends = weekends;
        this.foods = foods;
    }

    private ArrayList<Food> foods;

    public void setName(String name) {
        this.name = name;
    }
}
