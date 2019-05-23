package input;

import output.OutputManger;
import world.WorldItems;
import player.Inventory;
import player.Location;
import util.Helper;

public class CommandParser {

    /**
     * Called every time player writes a command
     * @param inpString player's input command as string
     */
    void parse(String inpString) {

        parse(Command.fromInputString(inpString), inpString);
    }

    private void parse(Command command, String inpString) {

        switch (command) {

            case EXIT:
                break;
            case LOOK:
                OutputManger.printInfoForCurrentLocation();
                break;
            case NORTH:
                Location.CURRENT.updateLocation(0, 1);
                OutputManger.printInfoForCurrentLocation();
                break;
            case SOUTH:
                Location.CURRENT.updateLocation(0, -1);
                OutputManger.printInfoForCurrentLocation();
                break;
            case WEST:
                Location.CURRENT.updateLocation(-1, 0);
                OutputManger.printInfoForCurrentLocation();
                break;
            case EAST:
                Location.CURRENT.updateLocation(1, 0);
                OutputManger.printInfoForCurrentLocation();
                break;
            case PICK:
                WorldItems.INSTANCE.pickUpItem(Helper.getArgument(inpString));
                break;
            case USE:
                Inventory.INSTANCE.useItem(Helper.getArgument(inpString));
                break;
            case INVENTORY:
                OutputManger.printInventory();
                break;
            case INPUT_ERROR:
                OutputManger.printCommandInputError();
                break;
        }

    }
}
