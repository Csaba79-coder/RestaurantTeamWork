package utils;

import controller.StorageController;
import java.io.*;

import order.Order;
import order.OrderController;
import storage.Drink;
import storage.KitchenTool;
import storage.Meal;
import storage.StorageElement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FileHandler {
    /**
     * FileHandler class should be used to uplaod data from files
     *
     * hint: String split() method
     */
    private final String STORAGES_DIR = "src/Restaurant - Rob/src/resources/storages/"; // "src" + File.separator + "resources" + File.separator + "storages" + File.separator;
    private final String ORDERS_DIR = "src/Restaurant - Rob/src/resources/orders/"; // "src" + File.separator + "resources" + File.separator + "orders";

    public void loadStorages() throws IOException {
        loadDrinks();
        loadMeals();
        loadKitchenTools();
    }

    private void loadDrinks() throws IOException {
        Set<StorageElement> temp =  new HashSet<>();
        String path = getSTORAGES_DIR() + "Drinks.txt";
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for (String line; (line = bufferedReader.readLine()) != null; ) {
            Drink drink = new Drink();
            drink.setName(line.split(",")[0]);
            drink.setAmount(Integer.parseInt(line.split(",")[1]));
            temp.add(drink);
        }
        StorageController.setDrinkStorage(temp);
        System.out.println("Drink storage has been loaded succesfully!");
    }

    private void loadMeals() throws IOException {
        Set<StorageElement> temp = new HashSet<>();
        String path = getSTORAGES_DIR() + "Meals.txt";
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for (String line; (line = bufferedReader.readLine()) != null; ) {
            Meal meal = new Meal();
            meal.setName(line.split(",")[0]);
            meal.setAmount(Integer.parseInt(line.split(",")[1]));
            temp.add(meal);
        }
        StorageController.setMealStorage(temp);
        System.out.println("Meal storage has been loaded succesfully!");
    }

    private void loadKitchenTools() throws IOException {
        Set<StorageElement> temp = new HashSet<>();
        String path = getSTORAGES_DIR() + "KitchenTools.txt";
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for (String line; (line = bufferedReader.readLine()) != null; ) {
            KitchenTool tool = new KitchenTool();
            tool.setName(line.split(",")[0]);
            tool.setAmount(Integer.parseInt(line.split(",")[1]));
            temp.add(tool);
        }
        StorageController.setKitchenToolStorage(temp);
        System.out.println("Kitchen tool storage has been loaded succesfully!");
    }

    public void loadOrders() throws IOException {
        int counter = 0;
        Set<Order> orders = new HashSet<>();
        File dataFolder = new File(getORDERS_DIR());
        if (dataFolder.list().length > 0) {
            File[] files = dataFolder.listFiles();
            for (File f : files) {
                counter++;
                HashMap<String, Integer> temp = new HashMap<>();
                Order order = new Order();
                FileReader fileReader = new FileReader(f.getPath());
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                for (String line; (line = bufferedReader.readLine()) != null; ) {
                    temp.put(line.split(",")[0], Integer.parseInt(line.split(",")[1]));
                    order.setOrderList(temp);

                }
                orders.add(order);
            }
        }
        OrderController.setOrderStorage(orders);
        System.out.println(counter + " order succesfully loaded!");
    }


    public String getSTORAGES_DIR() {
        return STORAGES_DIR;
    }

    public String getORDERS_DIR() {
        return ORDERS_DIR;
    }
}
