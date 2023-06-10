import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour {
    Queue<Customer> queue = new LinkedList<>();

    public Market() {
    }

    @Override
    public void addCustomerToQueue(Customer newCustomer) {
        queue.add(newCustomer);
    }

    @Override
    public Customer pullFirstFromQueue() {
        return queue.poll();
    }

    @Override
    public void queueToString() {
        Iterator<Customer> iter = queue.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().toString());
        }
    }

    @Override
    public void update() {
        this.completeOrder(this.pullFirstFromQueue());
    }

    @Override
    public void completeOrder(Customer customer) {
        System.out.println("Выдано со склада:\n" + customer.orderList());
    }


}