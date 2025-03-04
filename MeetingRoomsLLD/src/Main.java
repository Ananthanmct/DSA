import factory.Factory;
import repo.RoomDB;
import service.BookingService;
import service.EmployeeService;

public class Main {
    public static void main(String[] args) {

        Factory factory = new Factory();
        EmployeeService employeeService = new EmployeeService(factory);
        BookingService bookingService = new BookingService(factory, employeeService);

        employeeService.createEmployee(1, "Somendra");

        // Create meeting room service

    }
}