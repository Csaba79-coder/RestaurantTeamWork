package order;


import java.util.Set;

public class OrderController {

    private static Set<Order> orderStorage;

    public static Set<Order> getOrderStorage() {
        return orderStorage;
    }

    public static void setOrderStorage(Set<Order> orderStorage) {
        OrderController.orderStorage = orderStorage;
    }
}
