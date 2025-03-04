package models;

import java.util.List;

public class Office {
    List<Employee> employees;
    List<MeetingRoom> rooms;

    public Office(List<Employee> employees) {
        this.employees = employees;
    }

    public Office() {
    }

    public List<MeetingRoom> getRooms() {
        return rooms;
    }

    public void setRooms(List<MeetingRoom> rooms) {
        this.rooms = rooms;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
