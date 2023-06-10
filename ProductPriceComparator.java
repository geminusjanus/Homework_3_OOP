import java.util.Comparator;

public class ProductPriceComparator<T extends Product> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getPrice() - o2.getPrice();
    }

    @Override
    public Comparator<T> reversed() {
        return Comparator.super.reversed();
    }
}