import java.util.Comparator;

public class FoodProduceDateComparator<T extends Food> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return (int) (o1.getProdDateMs() - o2.getProdDateMs());
    }

    @Override
    public Comparator<T> reversed() {
        return Comparator.super.reversed();
    }
}