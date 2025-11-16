import java.util.*;

public class Order {
    private String orderId;
    private List<OrderItem> items = new ArrayList<>();

    public Order(String id) {
        this.orderId = id;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(OrderItem::getTotal).sum();
    }
}