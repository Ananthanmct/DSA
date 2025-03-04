package models;

import java.util.List;

public class MeetingRoom {
    int id;
    List<Slot> meetings;
    int roomCapacity;

    public MeetingRoom(int id, List<Slot> meetings, int roomCapacity) {
        this.id = id;
        this.meetings = meetings;
        this.roomCapacity = roomCapacity;
    }

    public MeetingRoom() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Slot> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Slot> meetings) {
        this.meetings = meetings;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }
}
