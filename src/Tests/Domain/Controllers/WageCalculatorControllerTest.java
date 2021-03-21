package Tests.Domain.Controllers;

import Domain.Controllers.WageCalculatorController;
import Domain.Models.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WageCalculatorControllerTest {
    WageCalculatorController wageCalculatorController;
    List<Result> results;
    Result result;

    @BeforeEach
    public void setup() {
        results = wageCalculatorController.getResults();
        result = new Result("RENE", 215);
    }

    @Test
    void getResults() {
        assertDoesNotThrow((Executable) wageCalculatorController::getResults);
        assertNotNull(results);
        assertEquals(result.getName(), results.get(0).getName());
        assertEquals(result.getAmountToPay(), results.get(0).getAmountToPay());
    }
}