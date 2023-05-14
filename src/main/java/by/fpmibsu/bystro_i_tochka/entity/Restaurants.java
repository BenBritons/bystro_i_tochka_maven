package by.fpmibsu.bystro_i_tochka.entity;

import jdk.vm.ci.meta.Local;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Restaurants {

    public Restaurants(Address location, LocalTime workTimeStart, LocalTime workTimeEnd) {
        this.location = location;
        this.workTimeStart = workTimeStart;
        this.workTimeEnd = workTimeEnd;
    }

    public Restaurants(Address location, LocalTime workTimeStart, LocalTime workTimeEnd, DayOfWeek...weekendDays) {
        this.location = location;
        this.workTimeStart = workTimeStart;
        this.workTimeEnd = workTimeEnd;
        this.weekends = new HashSet<>();
        Collections.addAll(weekends, weekendDays);
    }


    public Restaurants() {
        this.location = new Address();
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

    public Set<DayOfWeek> getWeekends() {
        return weekends;
    }

    public void setWeekends(Set<DayOfWeek> weekends) {
        this.weekends = weekends;
    }

    private Address location;

    private LocalTime workTimeStart;
    private LocalTime workTimeEnd;

    private Set<DayOfWeek> weekends;
}
