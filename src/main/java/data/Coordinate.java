package data;

import util.Constants;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * @return Unique number for each grid position.
     */
    public int getId() {
        return y * Constants.MAP_LENGTH + x;
    }
}
