package repo;

import models.Employee;
import models.MeetingRoom;

import java.util.HashMap;

public class EmployeeDB {
    // unordered map -> HashMap -> Multiple
    // Ordered map -> TreeMap
    // HashTable -> Sunchronized
    HashMap<Integer, Employee> employeeHashMap;

    public EmployeeDB(){
        this.employeeHashMap = new HashMap<>();
    }

    public Employee getById(int id){
        return this.employeeHashMap.get(id);
    }

    public void addEmployee(int id, Employee employee){
        employeeHashMap.put(id, employee);
    }
}
