package world;

import data.models.ItemModel;
import output.OutputManger;
import player.Inventory;
import player.Location;
import util.Constants;

import java.util.ArrayList;
import java.util.List;

/* Singleton pattern */
public enum WorldItems {
    INSTANCE;

    private List<ItemModel> worldItems = new ArrayList<>();

    public void addItemToWorld(ItemModel model) {
        worldItems.add(model);
    }


    /**
     * Removes the item from the world.
     * Adds it to the player's inventory.
     *
     * @param name Item name that the player requested to pick up.
     */
    public void pickUpItem(String name) {
        ItemModel pickedUpItem = getPickedUpItem(name);

        if (pickedUpItem != null) {
            worldItems.remove(pickedUpItem);
            Inventory.INSTANCE.putItem(pickedUpItem);
            OutputManger.printPickedUpItemMessage(pickedUpItem);
        }
        else {
            OutputManger.printGenericError(Constants.ERROR_NO_PICK_ITEM);
        }
    }

    /**
     * Pick up item without printing to console.
     * Used for initial setup.
     */
    public void silentPickUpItem(String name) {
        ItemModel pickedUpItem = getPickedUpItem(name);

        if (pickedUpItem != null) {
            worldItems.remove(pickedUpItem);
            Inventory.INSTANCE.putItem(pickedUpItem);
        }
    }

    /**
     * @param name Item name that the player requested to pick up.
     * @return Item that is at the current location and matches the input name.
     */
    private ItemModel getPickedUpItem(String name) {

        String strLocation = Location.CURRENT.coordinate.getX() + "," + Location.CURRENT.coordinate.getY();

        for (ItemModel item : worldItems) {
            if (strLocation.equals(item.getLocationInWorld())
                    && name.equals(item.getName())) {

                return item;
            }
        }
        return null;
    }

    //Debug only
    public void printAll() {
        for (ItemModel itemModel : worldItems) {
            System.out.println(itemModel.getName());
        }
    }
}
