import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;


public class Customer<T extends Product> {
    private String name;
    private HashMap<T, Integer> productList = new HashMap();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addProduct(T product, int count) {
        productList.put(product, count);
    }

    public String orderList() {
        StringBuilder res = new StringBuilder();
        Iterator<T> iter = this.productList.keySet().iterator();
        while (iter.hasNext()) {
            T current = iter.next();
            res.append(this.productList.get(current)).append("x").append(current.toString()).append("\n");
        }
        return res.toString();

    }

    @Override
    public String toString() {
        String res = "Список покупок " + this.name + ":\n" +
                this.orderList();
        return res;
    }

}