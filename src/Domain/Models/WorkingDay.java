package Domain.Models;

import java.time.LocalTime;

public class WorkingDay {
    private final String day;
    private final LocalTime start;
    private final LocalTime end;

    /**
     * Class that represents a working day of an employee
     *
     * @param day   day that the employee worked on
     * @param start time in witch the employee started working
     * @param end   time in witch the employee finished working
     */
    public WorkingDay(String day, LocalTime start, LocalTime end) {
        this.day = day;
        this.start = start;
        this.end = end;
    }

    public String getDay() {
        return day;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

}
