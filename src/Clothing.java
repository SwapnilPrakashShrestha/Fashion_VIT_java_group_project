public class Clothing extends Product {
    private String size;
    private String color;

    public Clothing(String id, String name, double price, String size, String color) {
        super(id, name, price);
        this.size = size;
        this.color = color;
    }
}