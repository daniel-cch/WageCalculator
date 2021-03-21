package Tests.Domain.Models;

import Domain.Models.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ResultTest {
    Result result;

    @BeforeEach
    public void setup() {
        result = new Result("Daniel", 120);
    }

    @Test
    void getName() {
        assertNotNull(result);
        assertNotNull(result.getName());
        assertEquals("Daniel", result.getName());
    }

    @Test
    void getAmountToPay() {
        assertNotNull(result);
        assertEquals(120, result.getAmountToPay());
    }
}