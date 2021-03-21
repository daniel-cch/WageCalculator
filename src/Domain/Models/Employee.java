package Domain.Models;

import java.util.List;

public class Employee {
    private final String name;
    private final List<WorkingDay> workingDays;

    /**
     * Object that represents and employee
     *
     * @param name        name of employee
     * @param workingDays List that contains the working days of employee
     */
    public Employee(String name, List<WorkingDay> workingDays) {
        this.name = name;
        this.workingDays = workingDays;
    }

    public String getName() {
        return name;
    }

    public List<WorkingDay> getWorkingDays() {
        return workingDays;
    }

}
