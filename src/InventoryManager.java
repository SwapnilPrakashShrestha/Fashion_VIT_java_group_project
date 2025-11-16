import java.util.*;

public class InventoryManager {
    private static InventoryManager instance;
    private Map<String, Integer> stock = new HashMap<>();

    private InventoryManager() {}

    public static InventoryManager getInstance() {
        if (instance == null)
            instance = new InventoryManager();
        return instance;
    }

    public void updateStock(String productId, int qty) {
        stock.put(productId, qty);
    }

    public int getStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }
}