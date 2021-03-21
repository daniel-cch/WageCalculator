package Data.Repository;

import Domain.Models.Employee;
import Domain.Models.WorkingDay;
import Domain.Repository.ReadDataInterface;

import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadData implements ReadDataInterface {

    //Gets data from txt and return a List of type Employee

    /**
     * This method will retrieve data from a txt and
     *
     * @return List<Employee>
     * @throws Exception A Error reading file will be throw if data from the txt is invalid
     */
    @Override
    public List<Employee> getEmployees() throws Exception {
        List<Employee> employees = new ArrayList<>();

        try {
            File file = new File("data.txt");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!data.isEmpty()) {
                    Employee employee = new Employee(getName(data), getWorkingDays(data));

                    employees.add(employee);
                }
            }

            myReader.close();
            return employees;
        } catch (Exception e) {
            throw new Exception("Error reading file");
        }
    }

    /**
     * This method will parse the name of an employee from a given txt line
     *
     * @param data data is one line retrieved by the txt
     * @return String
     * @throws Exception Method throws a Invalid data Exception if data is invalid
     */
    private String getName(String data) throws Exception {
        try {
            return data.split("=")[0].toUpperCase();
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception("Invalid data.");
        }
    }

    /**
     * This method parse the day and time from txt data
     *
     * @param data data is one line retrieved by the txt
     * @return List<WorkingDay>
     * @throws Exception Method throws Invalid time data if data is not on correct format or time is not valid
     */
    private List<WorkingDay> getWorkingDays(String data) throws Exception {
        List<WorkingDay> workingDays = new ArrayList<>();
        String days = data.split("=")[1];

        try {
            for (String day : days.split(",")) {
                String dayName = day.substring(0, 2).toUpperCase();
                LocalTime start = LocalTime.parse(day.substring(2).split("-")[0]);
                LocalTime end = LocalTime.parse(day.substring(2).split("-")[1]);

                if (start.isAfter(end) || end.isBefore(start))
                    throw new Exception("Invalid Time data");

                workingDays.add(new WorkingDay(dayName, start, end));
            }

            return workingDays;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception("Invalid data.");
        }
    }
}
