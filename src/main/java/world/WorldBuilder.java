package world;

import data.parser.items.ItemParser;
import data.parser.orientation.OrientationParser;
import input.CommandParser;
import output.OutputManger;
import player.Inventory;
import util.Constants;

public class WorldBuilder {

    /**
     * Calls corresponding methods to parse the jsons and to add the walls.
     * Called on game start.
     */
    public static void start() {

        ItemParser.INSTANCE.parseJson();
        OrientationParser.INSTANCE.parseJson();

        addWalls();
        addInitialItems();
    }

    private static void addWalls() {

        WorldMap.INSTANCE.setSingleWall(4, 5);
        WorldMap.INSTANCE.setSingleWall(0, 4);
        WorldMap.INSTANCE.setSingleWall(1, 2);
        WorldMap.INSTANCE.setSingleWall(6, 2);
        WorldMap.INSTANCE.setSingleWall(7, 3);
        WorldMap.INSTANCE.setSingleWall(8, 9);
        WorldMap.INSTANCE.setSingleWall(9, 13);
        WorldMap.INSTANCE.setSingleWall(10, 14);
        WorldMap.INSTANCE.setSingleWall(14, 15);
    }

    private static void addInitialItems() {
        WorldItems.INSTANCE.silentPickUpItem(Constants.OATHBRINGER);

        OutputManger.printIntro();
        OutputManger.printInfoForCurrentLocation();
    }
}
