package service;

import exception.SlotOccupiedException;
import factory.Factory;
import models.Employee;
import models.MeetingRoom;
import models.Slot;
import repo.EmployeeDB;
import repo.RoomDB;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;
import java.util.UUID;

public class BookingService {

    EmployeeDB employeeDB;

    RoomDB roomDB;

    EmployeeService employeeService;

    public BookingService(Factory factory, EmployeeService employeeService){
        this.employeeDB = factory.provideEmployeeDB();
        this.roomDB = factory.provideRoomDB();
        this.employeeService = employeeService;
    }

    public void bookingMeetingRoom(int roomId,
                                   int hostId,
                                   LocalDateTime startTime,
                                   LocalDateTime endTime,
                                   List<Integer> invities){
        // with the help of roomId bring room object
        // with the help of userid -> bring employee object


        MeetingRoom room = roomDB.getById(roomId);
        Employee employee = employeeDB.getById(hostId);

        // Slots in meeting room are in sorted manner on the basis of start time

        List<Slot> slots = room.getMeetings();

        LocalDateTime referenceTime = LocalDateTime.of(2014, 1, 1, 0, 0, 0);

        long startTimeInt = Duration.between(referenceTime, startTime).getSeconds();
        long endTimeInt = Duration.between(referenceTime, endTime).getSeconds();


        // move this to utility
        for(Slot slot : slots){
            if(slot.getEndTime() > startTimeInt){
                // Throw exception
                throw new SlotOccupiedException(String.format("Meeting room with id %d is already occuped for your slot " +
                        "Starting with time %s and ends with time %s", roomId, startTime.toString(), endTime.toString()));
            }
        }

        List<Employee> employees = employeeService.getEmployees(invities);

        // We need to keep this slot at its correct position
        // move this to utility
        Slot currSlot = new Slot(startTimeInt, endTimeInt, 0L,employees );
        for(int i = 0; i < slots.size(); i++){
            if(slots.get(i).getEndTime() > endTimeInt){
                slots.add(currSlot);
            }
        }



    }

}
