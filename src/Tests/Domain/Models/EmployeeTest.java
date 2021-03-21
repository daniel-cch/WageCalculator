package Tests.Domain.Models;

import Domain.Models.Employee;
import Domain.Models.WorkingDay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmployeeTest {
    List<WorkingDay> workingDayList;
    Employee employee;

    @BeforeEach
    public void setup() {
        workingDayList = Arrays.asList(new WorkingDay("MO", LocalTime.parse("00:00"), LocalTime.parse("12:00")));
        employee = new Employee("daniel", workingDayList);
    }

    @Test
    void getName() {
        assertNotNull(employee);
        assertNotNull(employee.getName());
        assertEquals("daniel", employee.getName());
    }

    @Test
    void getWorkingDays() {
        assertNotNull(employee);
        assertNotNull(employee.getWorkingDays());
        assertEquals(1, employee.getWorkingDays().size());
    }
}