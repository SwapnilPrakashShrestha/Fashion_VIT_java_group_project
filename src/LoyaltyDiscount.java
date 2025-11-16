public class LoyaltyDiscount implements DiscountStrategy {
    private double rate;

    public LoyaltyDiscount(double rate) {
        this.rate = rate;
    }

    public double applyDiscount(double amount) {
        return amount - rate;
    }
}