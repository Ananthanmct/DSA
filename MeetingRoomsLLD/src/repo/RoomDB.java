package repo;

import models.MeetingRoom;

import java.util.HashMap;

public class RoomDB {
    HashMap<Integer, MeetingRoom> roomMap;

    public RoomDB(){
        roomMap = new HashMap<>();
    }

    public MeetingRoom getById(int id){
        return roomMap.get(id);
    }

    public void addRoom(int id, MeetingRoom roomDB){
        roomMap.put(id, roomDB);
    }

}
