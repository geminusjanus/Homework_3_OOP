public class Drink extends Food {
    private double volume;

    public Drink(String name, int price, double volume, String prodDate, int shelfLife) {
        super(name, price, prodDate, shelfLife);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }
}