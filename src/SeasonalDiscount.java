public class SeasonalDiscount implements DiscountStrategy {
    private double percentage;

    public SeasonalDiscount(double percentage) {
        this.percentage = percentage;
    }

    public double applyDiscount(double amount) {
        return amount - (amount * percentage / 100);
    }
}