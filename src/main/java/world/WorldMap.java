package world;

import player.Location;
import data.models.NavModel;

import java.util.HashMap;

/* Singleton pattern */
public enum WorldMap {
    INSTANCE;

    private HashMap<String, NavModel> map = new HashMap<>();

    public void addNavModelToMap(String location, NavModel model) {
        map.put(location, model);
    }

    public Location getPlayerLocation() {
        return Location.CURRENT;
    }

    public NavModel getInfoOnLocation() {
        String mapKey = Location.CURRENT.x + "," + Location.CURRENT.y;
        return map.get(mapKey);
    }
}

