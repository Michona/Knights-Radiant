package world;

import data.parser.items.ItemParser;
import data.parser.orientation.OrientationParser;

public class WorldBuilder {

    public static void start() {

        OrientationParser.INSTANCE.parseJson();
        ItemParser.INSTANCE.parseJson();

        addWalls();
    }

    private static void addWalls() {
        WorldMap.INSTANCE.setSingleWall(1, 6);
        WorldMap.INSTANCE.setSingleWall(6, 6);
    }
}
