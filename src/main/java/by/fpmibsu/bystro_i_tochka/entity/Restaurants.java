package by.fpmibsu.bystro_i_tochka.entity;

import java.time.DayOfWeek;
import java.time.LocalTime;;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Restaurants {

    public Restaurants(int id, Address location, LocalTime workTimeStart, LocalTime workTimeEnd) {
        this.id = id;
        this.location = location;
        this.workTimeStart = workTimeStart;
        this.workTimeEnd = workTimeEnd;
    }

    public Restaurants(int id, Address location, LocalTime workTimeStart, LocalTime workTimeEnd, DayOfWeek...weekendDays) {
        this.id = id;
        this.location = location;
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

    private LocalTime workTimeStart;
    private LocalTime workTimeEnd;

    private HashSet<DayOfWeek> weekends;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
