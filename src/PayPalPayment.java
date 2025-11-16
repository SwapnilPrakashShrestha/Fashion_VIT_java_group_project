public class PayPalPayment extends PaymentMethod {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public void processPayment(double amount) {
        System.out.println("Paid " + amount + " using PayPal (" + email + ")");
    }
}