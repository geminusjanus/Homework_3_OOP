abstract class Product implements Comparable<Product>{
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public int compareTo(Product o) {
        return this.getName().compareTo(o.getName());
    }
}