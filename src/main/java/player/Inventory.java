package player;

import data.models.ItemModel;
import output.OutputManger;
import util.Constants;

import java.util.ArrayList;
import java.util.List;

public enum Inventory {
    INSTANCE;

    public List<ItemModel> items = new ArrayList<>();


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


    public List<String> getItemNames() {
        List<String> names = new ArrayList<>();
        items.forEach(it -> names.add(it.getName()));
        return names;
    }
}
