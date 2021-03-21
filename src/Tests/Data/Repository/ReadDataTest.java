package Tests.Data.Repository;

import Data.Repository.ReadData;
import Domain.Models.Employee;
import Domain.Models.WorkingDay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadDataTest {
    List<Employee> employeeList;
    ReadData readData;
    Employee employee;

    @BeforeEach
    public void setup() {
        readData = new ReadData();

        try {
            employeeList = readData.getEmployees();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        employee = new Employee("RENE", Arrays.asList(
                new WorkingDay("MO", LocalTime.parse("10:00"), LocalTime.parse("12:00")),
                new WorkingDay("TU", LocalTime.parse("10:00"), LocalTime.parse("12:00")),
                new WorkingDay("TH", LocalTime.parse("01:00"), LocalTime.parse("03:00")),
                new WorkingDay("SA", LocalTime.parse("14:00"), LocalTime.parse("18:00")),
                new WorkingDay("SU", LocalTime.parse("20:00"), LocalTime.parse("21:00"))
        ));
    }

    @Test
    void getEmployees() {
        assertDoesNotThrow((Executable) readData::getEmployees);

        assertNotNull(employeeList);
        assertEquals(employee.getName(), employeeList.get(0).getName());
        assertEquals(employee.getWorkingDays().get(0).getDay(), employeeList.get(0).getWorkingDays().get(0).getDay());
        assertEquals(employee.getWorkingDays().get(0).getStart(), employeeList.get(0).getWorkingDays().get(0).getStart());
        assertEquals(employee.getWorkingDays().get(0).getEnd(), employeeList.get(0).getWorkingDays().get(0).getEnd());
    }
}