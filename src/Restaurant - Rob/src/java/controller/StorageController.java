package controller;

import storage.StorageElement;
import java.util.Set;

public class StorageController {
    /**
     * StorageController class shall be used to handle our storages
     * It shall dynamically handle the amounts each of our storage elements
     */

    private static Set<StorageElement> drinkStorage;
    private static Set<StorageElement> mealStorage;
    private static Set<StorageElement> kitchenToolStorage;

    public static Set<StorageElement> getDrinkStorage() {
        return drinkStorage;
    }

    public static void setDrinkStorage(Set<StorageElement> drinkStorage) {
        StorageController.drinkStorage = drinkStorage;
    }

    public static Set<StorageElement> getMealStorage() {
        return mealStorage;
    }

    public static void setMealStorage(Set<StorageElement> mealStorage) {
        StorageController.mealStorage = mealStorage;
    }

    public static Set<StorageElement> getKitchenToolStorage() {
        return kitchenToolStorage;
    }

    public static void setKitchenToolStorage(Set<StorageElement> kitchenToolStorage) {
        StorageController.kitchenToolStorage = kitchenToolStorage;
    }

    private static boolean hasEnough(String elementName, int amount) {
        for (StorageElement element : getDrinkStorage()) {
            if (element.getName().equalsIgnoreCase(elementName)) {
                if(element.getAmount() >= element.getAmount() - amount){
                    return true;
                }
            }
        }
        for (StorageElement element : getMealStorage()) {
            if (element.getName().equalsIgnoreCase(elementName)) {
                if(element.getAmount() >= element.getAmount() - amount){
                    return true;
                }
            }
        }
        for (StorageElement element : getKitchenToolStorage()) {
            if (element.getName().equalsIgnoreCase(elementName)) {
                if(element.getAmount() >= element.getAmount() - amount){
                    return true;
                }
            }
        }
        return false;
    }

    public static void removeElementOfStorage(String elementName, int amount) {
        if (hasEnough(elementName, amount)) {
            for (StorageElement element : getDrinkStorage()) {
                if (element.getName().equalsIgnoreCase(elementName)) {
                    element.setAmount(element.getAmount() - amount);
                    System.out.println(amount + " unit of the following: " + elementName + " deducted from the storage.");
                    removeDrinkTools(amount);
                    break;
                }
            }
            for (StorageElement element : getMealStorage()) {
                if (element.getName().equalsIgnoreCase(elementName)) {
                    element.setAmount(element.getAmount() - amount);
                    System.out.println(amount + " unit of the following: " + elementName + " deducted from the storage.");
                    removeMealTools(amount);
                    break;
                }
            }
        } else {
            System.out.println("Unable to succeed an order due to run out of the following element: " + elementName);
        }
    }

    public static void removeDrinkTools(int amount) {
        for (StorageElement element : getKitchenToolStorage()) {
            if (element.getName().equalsIgnoreCase("Pohár")) {
                element.setAmount(element.getAmount() - amount);
                System.out.println(amount + " unit of Pohár deducted from the storage.");
                break;
            }
        }
    }

    public static void removeMealTools(int amount) {
        for (StorageElement element : getKitchenToolStorage()) {
            if (!element.getName().equalsIgnoreCase("Pohár")) {
                element.setAmount(element.getAmount() - amount);
                System.out.println(amount + " unit of " + element.getName() + " deducted from the storage.");
            }
        }
    }

    public static void listStorage(){
        for (StorageElement element : getDrinkStorage()) {
            System.out.println(element.getName() + " : " + element.getAmount() + " unit.");
        }
        for (StorageElement element : getMealStorage()) {
            System.out.println(element.getName() + " : " + element.getAmount() + " unit.");
        }
        for (StorageElement element : getKitchenToolStorage()) {
            System.out.println(element.getName() + " : " + element.getAmount() + " unit.");
        }
    }
}
