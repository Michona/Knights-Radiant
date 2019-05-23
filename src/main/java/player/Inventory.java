package player;

import data.models.ItemModel;
import output.OutputManger;
import util.Constants;

import java.util.ArrayList;
import java.util.List;

/* Singleton pattern */
public enum Inventory {
    INSTANCE;

    public List<ItemModel> items = new ArrayList<>();

    /**
     * Checks if item is in the inventory and that the player is in a correct location to use it.
     * @param name Item name that the player requested to use.
     */
    public void useItem(String name) {

        boolean itemExistsInInventory = false;
        for (ItemModel item : items) {
            if (item.getName().equals(name)) {

                itemExistsInInventory = true;
                if (item.getUseLocation().equals(Location.CURRENT.toString())) {
                    OutputManger.printUsedItemMessage(item);
                    return;
                }
            }
        }

        if (itemExistsInInventory) {
            OutputManger.printWrongUsageLocation();
        }
        else {
            OutputManger.printGenericError(Constants.ERROR_USE_ITEM);
        }
    }

    public void putItem(ItemModel item) {
        items.add(item);
    }


    /**
     * Used when printing the inventory items.
     */
    public List<String> getItemNames() {
        List<String> names = new ArrayList<>();
        items.forEach(it -> names.add(it.getName()));
        return names;
    }
}
