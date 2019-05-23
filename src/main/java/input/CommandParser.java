package input;

import output.OutputManger;
import world.WorldItems;
import player.Inventory;
import player.Location;
import util.Helper;

public class CommandParser {

    /**
     * Called every time player writes a command
     *
     * @param inpString player's input command as string
     */
    void parse(String inpString) {

        parse(Command.fromInputString(inpString), inpString);
    }

    /**
     * Simple switch on the Command Enum.
     *
     * @param command Command to parse.
     * @param inpString used to get the argument string.
     */
    private void parse(Command command, String inpString) {

        switch (command) {

            case EXIT:
                break;
            case LOOK:
                OutputManger.printInfoForCurrentLocation();
                break;
            case NORTH:
                if (Location.CURRENT.updateLocation(0, 1)) {
                    OutputManger.printInfoForCurrentLocation();
                }
                break;
            case SOUTH:
                if (Location.CURRENT.updateLocation(0, -1)) {
                    OutputManger.printInfoForCurrentLocation();
                }
                break;
            case WEST:
                if (Location.CURRENT.updateLocation(-1, 0)) {
                    OutputManger.printInfoForCurrentLocation();
                }
                break;
            case EAST:
                if (Location.CURRENT.updateLocation(1, 0)) {
                    OutputManger.printInfoForCurrentLocation();
                }
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
