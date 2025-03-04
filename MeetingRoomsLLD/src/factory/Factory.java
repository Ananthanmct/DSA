package factory;

import repo.EmployeeDB;
import repo.RoomDB;



public class Factory {
    EmployeeDB employeeDB;
    RoomDB roomDB;

    public RoomDB provideRoomDB(){
        if(this.roomDB == null){
            this.roomDB = new RoomDB();
        }
        return this.roomDB;
    }

    public EmployeeDB provideEmployeeDB(){
        if(this.employeeDB == null){
            this.employeeDB = new EmployeeDB();
        }
        return this.employeeDB;
    }


}
