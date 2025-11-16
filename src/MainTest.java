public class MainTest {
    public static void main(String[] args) {

        Product p = new Clothing("C101", "T-Shirt", 30.0, "L", "Blue");
        Order order = new Order("O1001");
        order.addItem(new OrderItem(2, p.price));

        double total = order.calculateTotal();
        System.out.println("Order Total: " + total);

        DiscountStrategy discount = new SeasonalDiscount(10);
        total = discount.applyDiscount(total);
        System.out.println("After Seasonal Discount: " + total);

        PaymentFactory pf = new PaymentFactory();
        PaymentMethod pm = pf.getPaymentMethod("card");
        pm.processPayment(total);
    }
}