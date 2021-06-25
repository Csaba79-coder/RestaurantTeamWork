package controller;

import order.Order;
import order.OrderController;
import storage.Drink;
import storage.StorageElement;

import java.util.HashMap;

public class TableController {
    /**
     * TableController class shall be used to control our customer requests for each table
     * Shall cooperate with the StorageController
     */

    public static void sortOrders() {
        for (Order order: OrderController.getOrderStorage()) {
            HashMap<String, Integer> map = order.getOrderList();
            map.forEach((key, value) -> {
                StorageController.removeElementOfStorage(key, value);
            });
        }
    }
}
