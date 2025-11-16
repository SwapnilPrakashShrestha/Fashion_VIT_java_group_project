public class OrderItem {
    private int quantity;
    private double unitPrice;

    public OrderItem(int qty, double price) {
        this.quantity = qty;
        this.unitPrice = price;
    }

    public double getTotal() {
        return quantity * unitPrice;
    }
}