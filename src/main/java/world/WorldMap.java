package world;

import data.Coordinate;
import player.Location;
import data.models.NavModel;
import util.Constants;

import java.util.HashMap;

/* Singleton pattern */
public enum WorldMap {
    INSTANCE;

    private HashMap<String, NavModel> map = new HashMap<>();

    private boolean[][] wallBlocksBitmap = new boolean[Constants.NUMBER_OF_TILES][Constants.NUMBER_OF_TILES];

    public void setSingleWall(int coordinateId_1, int coordinateId_2) {
        wallBlocksBitmap[coordinateId_1][coordinateId_2] = true;
        wallBlocksBitmap[coordinateId_2][coordinateId_1] = true;
    }

    public void addNavModelToMap(String location, NavModel model) {
        map.put(location, model);
    }

    public Location getPlayerLocation() {
        return Location.CURRENT;
    }

    public NavModel getInfoOnLocation() {
        String mapKey = Location.CURRENT.coordinate.getX() + "," + Location.CURRENT.coordinate.getY();
        return map.get(mapKey);
    }


    /**
     * Checks if the next location is a valid location
     * @param nextLocation gotten from player input (ex: gn/ge/gw/gs)
     * @return true if player can move to the new location
     */
    public boolean canPlayerMove(Coordinate nextLocation) {

        return (nextLocation.getY() >= 0 && nextLocation.getX() >= 0)
                && (nextLocation.getX() < Constants.MAP_LENGTH && nextLocation.getY() < Constants.MAP_LENGTH)
                && !wallBlocksBitmap[Location.CURRENT.coordinate.getId()][nextLocation.getId()];
    }
}

