package player;

import data.Coordinate;
import output.OutputManger;
import world.WorldMap;

/* Singleton pattern */
public enum Location {
    CURRENT(new Coordinate(0, 0));

    public Coordinate coordinate;

    Location(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Checks if the next coordinate is valid. If it is then it updates the current Coordinate
     * @param deltaX The delta change. Given by the direction the player wants to move
     * @param deltaY The delta change. Given by the direction the player wants to move
     */
    public boolean updateLocation(int deltaX, int deltaY) {

        Coordinate nextCoordinate = new Coordinate(coordinate.getX() + deltaX, coordinate.getY() + deltaY);

        if (WorldMap.INSTANCE.canPlayerMove(nextCoordinate)) {
            coordinate = nextCoordinate;
            return true;
        }
        else {
            OutputManger.printCantMoveThere();
            return false;
        }
    }


    @Override
    public String toString() {
        return coordinate.getX() + "," + coordinate.getY();
    }
}
