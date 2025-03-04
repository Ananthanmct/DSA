package models;

import java.util.List;


public class Employee {
    int id;
    String name;
    List<Slot> calendar;

    public Employee(int id, String name, List<Slot> calendar) {
        this.id = id;
        this.name = name;
        this.calendar = calendar;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Slot> getCalendar() {
        return calendar;
    }

    public void setCalendar(List<Slot> calendar) {
        this.calendar = calendar;
    }
}
