public class Accessory extends Product {
    private String material;

    public Accessory(String id, String name, double price, String material) {
        super(id, name, price);
        this.material = material;
    }
}