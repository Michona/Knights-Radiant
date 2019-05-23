package world;

import data.models.ItemModel;
import output.OutputManger;
import player.Inventory;
import player.Location;
import util.Constants;

import java.util.ArrayList;
import java.util.List;

public enum WorldItems {
    INSTANCE;

    private List<ItemModel> worldItems = new ArrayList<>();

    public void addItemToWorld(ItemModel model) {
        worldItems.add(model);
    }


    public void pickUpItem(String name) {

        String strLocation = Location.CURRENT.coordinate.getX() + "," + Location.CURRENT.coordinate.getY();

        ItemModel pickedUpItem = null;
        for (ItemModel item : worldItems) {

            if (strLocation.equals(item.getLocationInWorld())
                    && name.equals(item.getName())) {

                pickedUpItem = item;
            }
        }

        if (pickedUpItem != null) {
            worldItems.remove(pickedUpItem);
            Inventory.INSTANCE.putItem(pickedUpItem);
            OutputManger.printPickedUpItemMessage(pickedUpItem);
        }
        else {
            OutputManger.printGenericError(Constants.ERROR_NO_PICK_ITEM);
        }
    }


    //Only for testing. TODO remove later
    public void printAll() {
        for (ItemModel itemModel : worldItems) {
            System.out.println(itemModel.getName());
        }
    }

}
