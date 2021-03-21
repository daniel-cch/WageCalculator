package Tests.Domain.Models;

import Domain.Models.WorkingDay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WorkingDayTest {
    WorkingDay workingDay;

    @BeforeEach
    public void setup() {
        workingDay = new WorkingDay("MO", LocalTime.parse("00:12"), LocalTime.parse("05:40"));
    }

    @Test
    void getDay() {
        assertNotNull(workingDay);
        assertNotNull(workingDay.getDay());
        assertEquals("MO", workingDay.getDay());
    }

    @Test
    void getStart() {
        assertNotNull(workingDay);
        assertNotNull(workingDay.getStart());
        assertEquals(LocalTime.parse("00:12"), workingDay.getStart());
    }

    @Test
    void getEnd() {
        assertNotNull(workingDay);
        assertNotNull(workingDay.getEnd());
        assertEquals(LocalTime.parse("05:40"), workingDay.getEnd());
    }
}