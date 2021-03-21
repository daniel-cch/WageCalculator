package Domain.Models;

public class Result {
    private final String name;
    private final int amountToPay;

    /**
     * Class that represents the result of the final calculation
     *
     * @param name   name of employee
     * @param amount amount to pay employee
     */
    public Result(String name, int amount) {
        this.name = name;
        this.amountToPay = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmountToPay() {
        return amountToPay;
    }
}
