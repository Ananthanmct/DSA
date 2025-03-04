package models;

import java.time.LocalDate;
import java.util.List;

public class Slot {
    Long startTime;
    Long endTime;
    Long meetingDate;
    List<Employee> employees;

    public Slot(Long startTime, Long endTime, Long meetingDate, List<Employee> employees) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetingDate = meetingDate;
        this.employees = employees;
    }

    public Slot() {
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Long meetingDate) {
        this.meetingDate = meetingDate;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
