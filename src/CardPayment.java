public class CardPayment extends PaymentMethod {
    private String cardNum;

    public CardPayment(String cardNum) {
        this.cardNum = cardNum;
    }

    public void processPayment(double amount) {
        System.out.println("Paid " + amount + " using Card (" + cardNum + ")");
    }
}