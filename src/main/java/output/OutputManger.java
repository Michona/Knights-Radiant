package output;

import data.models.ItemModel;
import data.models.NavModel;
import player.Inventory;
import player.Location;
import util.Constants;
import world.WorldMap;

public class OutputManger {

    public static void printInfoForCurrentLocation() {
        NavModel model = WorldMap.INSTANCE.getInfoOnLocation();

        if (model != null) {
            System.out.println(model.getStory());
        }
    }

    public static void printUsedItemMessage(ItemModel item) {
        if (item != null) {
            System.out.println(item.getUsageMessage());
        }
    }

    public static void printPickedUpItemMessage(ItemModel item) {
        System.out.println(Constants.ITEM_PICKED_UP);
    }

    public static void printInventory() {
        for (String name : Inventory.INSTANCE.getItemNames()) {
            System.out.println(name);
        }
    }

    public static void printCommandInputError() {
        System.out.println(Constants.ERROR_PLAYER_INPUT);
    }

    public static void printWrongUsageLocation() {
        System.out.println(Constants.WRONG_USAGE_LOC_ITEM);
    }

    public static void printCantMoveThere() {
        System.out.println(Constants.CANT_MOVE_THERE);
    }


    public static void printGenericError(String error) {
        System.out.println(error);
    }

    //Debug only
    public static void printCurrentLocationDebugInfo() {
        System.out.println(Location.CURRENT.coordinate.getX() + " - " + Location.CURRENT.coordinate.getY());
        System.out.println(Location.CURRENT.coordinate.getId());
    }
}


