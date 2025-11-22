public class AllTestCases {

    public static void main(String[] args) {
        System.out.println("=== Running Test Cases ===\n");

        // TC-001, TC-002: Test Card and PayPal Payment
        testPaymentMethods();

        // TC-004: Test Singleton Pattern
        testSingletonPattern();

        // TC-005: Clothing Product Test
        testClothingProduct();

        // TC-006: Accessory Product Test
        testAccessoryProduct();

        // TC-014: Order Calculation Test
        testOrderCalculation();

        // TC-017, TC-018, TC-021: Inventory Tests
        testInventoryOperations();

        // TC-022, TC-023: Loyalty Discount Test
        testLoyaltyDiscount();

        // TC-025: Strategy Pattern Test
        testStrategyPattern();

        // TC-026: Factory Pattern Test
        testFactoryPattern();

        // TC-027, TC-028: End-to-End Tests
        testEndToEnd();
    }

    // TC-001, TC-002: Test Card and PayPal Payment
    public static void testPaymentMethods() {
        System.out.println("--- Test Payment Methods ---");
        PaymentFactory pf = new PaymentFactory();

        // Test Card Payment
        PaymentMethod card = pf.getPaymentMethod("card");
        card.processPayment(54.0);

        // Test PayPal Payment
        PaymentMethod paypal = pf.getPaymentMethod("paypal");
        paypal.processPayment(54.0);
        System.out.println();
    }

    // TC-004: Test Singleton Pattern
    public static void testSingletonPattern() {
        System.out.println("--- Test Singleton Pattern ---");
        InventoryManager im1 = InventoryManager.getInstance();
        InventoryManager im2 = InventoryManager.getInstance();
        System.out.println("Same instance: " + (im1 == im2)); // Should be true
        System.out.println();
    }

    // TC-005: Clothing Product Test
    public static void testClothingProduct() {
        System.out.println("--- Test Clothing Product ---");
        Clothing shirt = new Clothing("C101", "T-Shirt", 30.0, "L", "Blue");
        System.out.println("Size: " + shirt.getSize() + ", Color: " + shirt.getColor());
        System.out.println();
    }

    // TC-006: Accessory Product Test
    public static void testAccessoryProduct() {
        System.out.println("--- Test Accessory Product ---");
        Accessory belt = new Accessory("A201", "Leather Belt", 45.0, "Leather");
        System.out.println("Material: " + belt.getMaterial());
        System.out.println();
    }

    // TC-014: Order Calculation Test
    public static void testOrderCalculation() {
        System.out.println("--- Test Order Calculation ---");
        Order order = new Order("O1002");
        order.addItem(new OrderItem(3, 25.0)); // 3 items at $25
        double total = order.calculateTotal();
        System.out.println("Total: " + total); // Should be 75.0
        System.out.println();
    }

    // TC-017, TC-018, TC-021: Inventory Tests
    public static void testInventoryOperations() {
        System.out.println("--- Test Inventory Operations ---");
        InventoryManager inv = InventoryManager.getInstance();
        inv.updateStock("C101", 100);
        int stock = inv.getStock("C101");
        System.out.println("Stock: " + stock); // Should be 100

        inv.updateStock("C101", -10);
        stock = inv.getStock("C101");
        System.out.println("After sale: " + stock); // Should be 90
        System.out.println();
    }

    // TC-022, TC-023: Loyalty Discount Test
    public static void testLoyaltyDiscount() {
        System.out.println("--- Test Loyalty Discount ---");
        DiscountStrategy loyalty = new LoyaltyDiscount(15);
        double discounted = loyalty.applyDiscount(100.0);
        System.out.println("After loyalty discount: " + discounted); // Should be 85.0
        System.out.println();
    }

    // TC-025: Strategy Pattern Test
    public static void testStrategyPattern() {
        System.out.println("--- Test Strategy Pattern ---");
        DiscountStrategy[] strategies = {
                new SeasonalDiscount(10),
                new LoyaltyDiscount(15)
        };
        for (DiscountStrategy s : strategies) {
            System.out.println("Discount applied: " + s.applyDiscount(100.0));
        }
        System.out.println();
    }

    // TC-026: Factory Pattern Test
    public static void testFactoryPattern() {
        System.out.println("--- Test Factory Pattern ---");
        PaymentFactory factory = new PaymentFactory();
        PaymentMethod card = factory.getPaymentMethod("card");
        PaymentMethod paypal = factory.getPaymentMethod("paypal");
        System.out.println("Card created: " + (card != null));
        System.out.println("PayPal created: " + (paypal != null));
        System.out.println();
    }

    // TC-027, TC-028: End-to-End Tests
    public static void testEndToEnd() {
        System.out.println("--- Test End-to-End Transaction ---");

        // Create product
        Product product = new Clothing("C102", "Jeans", 80.0, "M", "Black");

        // Create order
        Order order = new Order("O1003");
        order.addItem(new OrderItem(1, product.price));

        // Calculate total
        double total = order.calculateTotal();
        System.out.println("Subtotal: " + total);

        // Apply discount
        DiscountStrategy discount = new LoyaltyDiscount(20);
        total = discount.applyDiscount(total);
        System.out.println("After discount: " + total);

        // Process payment
        PaymentFactory pf = new PaymentFactory();
        PaymentMethod payment = pf.getPaymentMethod("paypal");
        payment.processPayment(total);
        System.out.println();
    }
}
