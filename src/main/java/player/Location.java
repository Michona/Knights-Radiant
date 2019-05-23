package player;

import data.Coordinate;
import output.OutputManger;
import util.Constants;
import world.WorldMap;

public enum Location {
    CURRENT(new Coordinate(0, 0));

    public Coordinate coordinate;

    Location(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void updateLocation(int deltaX, int deltaY) {

        Coordinate nextCoordinate = new Coordinate(coordinate.getX() + deltaX, coordinate.getY() + deltaY);

        if (WorldMap.INSTANCE.canPlayerMove(nextCoordinate)) {
            coordinate = nextCoordinate;
        }
        else {
            OutputManger.printCantMoveThere();
        }
    }


    @Override
    public String toString() {
        return coordinate.getX() + "," + coordinate.getY();
    }
}
