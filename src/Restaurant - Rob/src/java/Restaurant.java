import controller.StorageController;
import controller.TableController;
import utils.FileHandler;

import java.io.IOException;

public class Restaurant {
    public static void main(String[] args) throws IOException {
        FileHandler handler = new FileHandler();
        handler.loadStorages();
        handler.loadOrders();
        StorageController.listStorage();
        TableController.sortOrders();
        StorageController.listStorage();
    }
}
