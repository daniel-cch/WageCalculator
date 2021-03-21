package Domain.Controllers;

import Data.Repository.ReadData;
import Domain.Models.Employee;
import Domain.Models.Result;
import Domain.Models.WorkingDay;
import Domain.Utilis.Days;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class WageCalculatorController {

    /**
     * This method retrieves data from repository and calculates the amount to pay each employee
     *
     * @return List<Results>
     */
    public List<Result> getResults() {
        List<Result> results = new ArrayList<>();
        ReadData data = new ReadData();

        try {
            List<Employee> employees = data.getEmployees();
            results = calculateWage(employees);
        } catch (Exception e) {
            System.out.print(e.toString());
        }

        return results;
    }

    /**
     * This method iterates all employees and calculates its daily wage
     * If data is invalid it will not include user on result
     *
     * @param employees List of employees
     * @return List<Result>
     */
    private List<Result> calculateWage(List<Employee> employees) {
        List<Result> results = new ArrayList<>();

        for (Employee e : employees) {
            int amountToPay = 0;
            boolean validData = true;

            for (WorkingDay wd : e.getWorkingDays()) {
                if (Days.days.containsKey(wd.getDay())) {
                    amountToPay = amountToPay + calculateDailyWage(wd.getStart(), wd.getEnd(), Days.days.get(wd.getDay()));
                } else {
                    validData = false;
                }
            }

            //Add results if they are valid
            if (validData) {
                results.add(new Result(e.getName(), amountToPay));
            } else {
                System.out.println(e.getName() + " contains invalid data");
            }
        }

        return results;
    }

    /**
     * This method calculates wage from specific day
     *
     * @param start LocalTime with the start of shift
     * @param end   LocalTime with the end of shift
     * @param type  String that indicates if current day is a weekend or weekday
     * @return int
     * Return daily wage
     */
    private int calculateDailyWage(LocalTime start, LocalTime end, String type) {
        int dailyWage = 0;
        int hoursWorked;

        //Checks if employee have worked during 00:01 and 09:00
        if (start.isBefore(LocalTime.parse("09:01"))) {
            //Check how many hours the employee have worked in current time frame
            if (start.isBefore(LocalTime.parse("09:01")) && end.isBefore(LocalTime.parse("09:01"))) {
                hoursWorked = (int) Duration.between(start, end).toHours();
            } else {
                hoursWorked = (int) Duration.between(start, LocalTime.parse("09:01")).toHours();
            }

            dailyWage = dailyWage + ((type.equals("weekday") ? 25 : 30) * hoursWorked);
        }

        //Checks if employee have worked during 09:01 and 18:00
        if (((start.isAfter(LocalTime.parse("09:00")) && start.isBefore(LocalTime.parse("18:01")))) || (start.isBefore(LocalTime.parse("18:01")) && end.isAfter(LocalTime.parse("09:00")))) {
            //Check how many hours the employee have worked in current time frame
            if ((start.isAfter(LocalTime.parse("09:00")) && start.isBefore(LocalTime.parse("18:01"))) && end.isBefore(LocalTime.parse("18:01"))) {
                hoursWorked = (int) Duration.between(start, end).toHours();
            } else if ((start.isAfter(LocalTime.parse("09:00")) && start.isBefore(LocalTime.parse("18:01"))) && end.isAfter(LocalTime.parse("18:01"))) {
                hoursWorked = (int) Duration.between(start, LocalTime.parse("18:01")).toHours();
            } else if (start.isBefore(LocalTime.parse("09:00")) && end.isAfter(LocalTime.parse("18:01"))) {
                hoursWorked = (int) Duration.between(LocalTime.parse("09:00"), LocalTime.parse("18:01")).toHours();
            } else {
                hoursWorked = (int) Duration.between(LocalTime.parse("09:00"), end).toHours();
            }

            dailyWage = dailyWage + ((type.equals("weekday") ? 15 : 20) * hoursWorked);
        }

        //Checks if employee have worked during 18:01 and 00:00
        if (end.isAfter(LocalTime.parse(("18:00"))) && end.isBefore(LocalTime.parse("23:59"))) {
            //Check how many hours the employee have worked in current time frame
            if (start.isAfter(LocalTime.parse("18:00"))) {
                hoursWorked = (int) Duration.between(start, end).toHours();
            } else {
                hoursWorked = (int) Duration.between(LocalTime.parse("18:00"), end).toHours();
            }

            dailyWage = dailyWage + ((type.equals("weekday") ? 20 : 25) * hoursWorked);
        }

        return dailyWage;
    }
}
