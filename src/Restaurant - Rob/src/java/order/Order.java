package order;


import java.util.HashMap;

public class Order {

    private static int tableCounter = 0;

    private HashMap<String, Integer> orderList;
    private final int tableId;

    public Order(){
        this.tableId = tableCounter + 1;
    }

    public static int getTableCounter() {
        return tableCounter;
    }

    public HashMap<String, Integer> getOrderList() {
        return orderList;
    }

    public int getTableId() {
        return tableId;
    }

    public void setOrderList(HashMap<String, Integer> orderList) {
        this.orderList = orderList;
    }
}
