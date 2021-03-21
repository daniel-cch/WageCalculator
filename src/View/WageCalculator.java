package View;

import Domain.Controllers.WageCalculatorController;
import Domain.Models.Result;

import java.util.List;

public class WageCalculator {

    /**
     * Calls controller and displays data
     *
     * @param args empty args needed
     */
    public static void main(String[] args) {
        WageCalculatorController wageCalculatorController = new WageCalculatorController();
        List<Result> results = wageCalculatorController.getResults();

        for (Result r : results) {
            System.out.println("The amount to pay " + r.getName() + " is: " + r.getAmountToPay() + " USD");
        }
    }
}
