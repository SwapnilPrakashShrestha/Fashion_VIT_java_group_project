public class PaymentFactory {
    public PaymentMethod getPaymentMethod(String type) {
        if (type.equalsIgnoreCase("paypal"))
            return new PayPalPayment("user@example.com");
        if (type.equalsIgnoreCase("card"))
            return new CardPayment("1111-2222-3333-4444");
        return null;
    }
}